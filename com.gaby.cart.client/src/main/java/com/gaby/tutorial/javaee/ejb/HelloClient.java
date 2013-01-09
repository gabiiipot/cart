package com.gaby.tutorial.javaee.ejb;

import com.gaby.tutorial.javaee.ejb.generated.HelloService;

public class HelloClient {

    public static void main(String[] args) {
        try {
            HelloClient client = new HelloClient();
            client.doTest(args);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void doTest(String[] args) {
        try {
        	HelloService service = new HelloService();
            System.out.println("Retrieving the port from the following service: " + service);
            com.gaby.tutorial.javaee.ejb.generated.Hello port = (com.gaby.tutorial.javaee.ejb.generated.Hello) service.getHelloPort();
            System.out.println("Invoking the sayHello operation on the port.");

            String name;
            if (args.length > 0) {
                name = args[0];
            } else {
                name = "No Name";
            }

            String response = port.sayHello(name);
            System.out.println(response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}