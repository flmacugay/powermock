package com.mac;

import java.util.logging.Logger;

import com.mac.ws.WRequest;
import com.mac.ws.WResponse;

public class WsImpl extends AbstractProxy implements WsPort {

	public WsImpl() {
		super(WsImpl.class);

		System.out.println("in WsImpl constructor");
	}


	@Override
	public WResponse getAdjustment(WRequest request) {
		setup();
		
		System.out.println(getContext("call from impl"));
		
		WResponse response=invoke("getAdjustment", null, request);
		
		System.out.println("process completed...");
		
		return response;
	}


	@Override
	protected Logger getLogger() {
		return Logger.getLogger("WsImpl");
	}

}
