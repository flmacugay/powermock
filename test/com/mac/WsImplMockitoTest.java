package com.mac;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.mac.ws.WRequest;
import com.mac.ws.WResponse;


public class WsImplMockitoTest {


	@Test
	public void testGetAdjustment() {
		System.out.println("begin test");
		
		WRequest request=new WRequest();
		request.setId("1");
		request.setPage(5);
		request.setSystemId("sys1");
		request.setTransactionId("trn1");
		
		WResponse response = new WResponse();
		response.setCounter(100);
		response.setResCode("0");
		response.setResMessage("Success");
		
		//suppress(constructor(AbstractProxy.class));
		
		WsImpl ws = Mockito.spy(new WsImpl());
		
		
		Mockito.doNothing().when(ws).setup();
		
		Mockito.doReturn("hehehe!!!!").when(ws).getContext(Matchers.anyString());
		
		//error , will call ws.getContext then return
		//PowerMockito.when(ws.getContext(Matchers.anyString())).thenReturn("HAHAHHAA!!!!");
		
		
		// return response immediately
		Mockito.doReturn(response).when(ws).invoke(Matchers.anyString(), Matchers.any(), Matchers.any());
		
		//or execute method first then return response
		//PowerMockito.when(ws.invoke(Matchers.anyString(), Matchers.any(), Matchers.any())).thenReturn(response);
		
		assertEquals(response, ws.getAdjustment(request));
		

		
		//ws.invoke(Matchers.anyString(), Matchers.any(), Matchers.any());
		
		
		
		//ws.invoke(method, port, request)
		//assertTrue(true);
	}

}
