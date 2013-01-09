package com.gaby.tutorial.javaee.ejb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService
public class Hello {
    private String message = "Hello, ";

    public Hello() {}

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
