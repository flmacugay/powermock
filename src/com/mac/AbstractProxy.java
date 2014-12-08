package com.mac;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mac.ws.WResponse;


public abstract class AbstractProxy {

	private Map<String, Method> methodsMap;
	
	public AbstractProxy(Class clazz) {
		System.loadLibrary("hahah.dll");
		System.out.println("proxy constructor");
		Method[] methods=clazz.getMethods();
		
		methodsMap=new HashMap<String, Method>();
		for(Method m : methods) {
			methodsMap.put(m.getName(), m);
		}
	}
	
	protected void setup() {
		System.out.println("setup");
	}

	protected String getContext(String msg) {
		System.out.println("inside context "+msg);
		System.loadLibrary("hahah.dll");
		return "Context method "+msg;
	}
	
	protected WResponse invoke(String method, Object port, Object request) {
		System.out.println("invoke");
		getLogger().log(Level.WARNING, "logging");
		System.out.println(getContext("hello"));
		return new WResponse();
	}
	
	protected abstract Logger getLogger();
	
}
