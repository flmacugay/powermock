package com.mac;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.support.membermodification.MemberMatcher.constructor;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.mac.ws.SoapLogger;
import com.mac.ws.WRequest;
import com.mac.ws.WResponse;


@RunWith(PowerMockRunner.class)
//@PrepareForTest(WsImpl.class)
@PrepareForTest(SoapLogger.class)
@SuppressStaticInitializationFor("com.mac.WsImpl")
public class WsImplTest {


	@Test
	public void testGetAdjustment() throws Exception {
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
		
		suppress(constructor(AbstractProxy.class));
		
		WsImpl ws = PowerMockito.spy(Whitebox.newInstance(WsImpl.class));
		
		
		PowerMockito.doNothing().when(ws).setup();
		
		PowerMockito.doReturn("hehehe!!!!").when(ws).getContext(Matchers.anyString());
		
		
		//PowerMockito.mockStatic(SoapLogger.class);		
		suppress(PowerMockito.method(SoapLogger.class, "logRequest"));
		suppress(PowerMockito.method(SoapLogger.class, "logResponse"));
		
		//PowerMockito.doNothing().doThrow(Exception.class).when(SoapLogger.class);
		//SoapLogger.logRequest(request, JAXBContext.newInstance(WRequest.class));
		
		//PowerMockito.doNothing().when(SoapLogger.class, "logRequest", Matchers.anyObject(), Matchers.anyObject());
		
		
		//Mockito.doNothing().when(SoapLogger.logRequest(Matchers.anyObject(), Matchers.any(JAXBContext.class)));

		//SoapLogger.logRequest(request, JAXBContext.newInstance(WRequest.class));
		
		
		//error , will call ws.getContext then return
		//PowerMockito.when(ws.getContext(Matchers.anyString())).thenReturn("HAHAHHAA!!!!");
		
		
		// return response immediately
		PowerMockito.doReturn(response).when(ws).invoke(Matchers.anyString(), Matchers.any(), Matchers.any());
		
		
		
		//or execute method first then return response
		//PowerMockito.when(ws.invoke(Matchers.anyString(), Matchers.any(), Matchers.any())).thenReturn(response);
		
		
		
		
		assertEquals(response, ws.getAdjustment(request));
		

		
		//ws.invoke(Matchers.anyString(), Matchers.any(), Matchers.any());
		
		
		
		//ws.invoke(method, port, request)
		//assertTrue(true);
	}

}
