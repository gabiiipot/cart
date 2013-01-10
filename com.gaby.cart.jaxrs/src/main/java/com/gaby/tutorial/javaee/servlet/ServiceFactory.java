package com.gaby.tutorial.javaee.servlet;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
	
	private static final ServiceFactory INSTANCE = new ServiceFactory();
	
	private Map<String, Object> registeredServices = new HashMap<String, Object>();
	
	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return INSTANCE;
	}
	
	public void registerService(String mappedName, Object service) {
		registeredServices.put(mappedName, service);
	}
	
	public Object getService(String mappedName) {
		return registeredServices.get(mappedName);
	}
}
