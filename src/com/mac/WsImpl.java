package com.mac;

import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.mac.ws.SoapLogger;
import com.mac.ws.WRequest;
import com.mac.ws.WResponse;

public class WsImpl extends AbstractProxy implements WsPort {
	
	private static JAXBContext JAXWRequest;
    private static JAXBContext JAXWResponse;

    static {
        try {
            JAXWRequest = JAXBContext.newInstance(WRequest.class);
            JAXWResponse = JAXBContext.newInstance(WResponse.class);
        } catch (JAXBException e) {
            throw new ExceptionInInitializerError("Unable to create JAXBContext: " + e.getMessage());
        }
    }
    

	public WsImpl() {
		super(WsImpl.class);

		System.out.println("in WsImpl constructor");
	}


	@Override
	public WResponse getAdjustment(WRequest request) {
		setup();
		
		System.out.println(getContext("call from impl"));
		
		SoapLogger.logRequest(request, JAXWRequest);
		
		System.out.println(" logRequest done ");
		
		WResponse response=invoke("getAdjustment", null, request);
		
		System.out.println(" invoke done ");
		
		SoapLogger.logResponse(response, JAXWResponse);
		
		System.out.println(" logResponse done ");
		
		System.out.println("process completed...");
		
		return response;
	}


	@Override
	protected Logger getLogger() {
		return Logger.getLogger("WsImpl");
	}

}
