package com.gaby.tutorial.javaee.ejb;

import java.net.URL;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class CalculatorClient {

    public void setUp() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("openejb.embedded.remotable", "true");
        //properties.setProperty("httpejbd.print", "true");
        //properties.setProperty("httpejbd.indent.xml", "true");
        EJBContainer.createEJBContainer(properties);
    }

    public void test() throws Exception {
        Service calculatorService = Service.create(
                new URL("http://127.0.0.1:4204/Calculator?wsdl"),
                new QName("http://superbiz.org/wsdl", "CalculatorService"));

//        calculatorService

        CalculatorWs calculator = calculatorService.getPort(CalculatorWs.class);
        System.out.println(calculator.sum(4, 6));
        System.out.println(calculator.multiply(3, 4));
    }
    
    public static void main(String[] srgs) {
    	CalculatorClient client = new CalculatorClient();
    	try {
			client.setUp();
			client.test();
		} catch (Exception e) {
			e.printStackTrace();
		}    	
    }
}