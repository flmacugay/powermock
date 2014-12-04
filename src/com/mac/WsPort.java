package com.mac;

import com.mac.ws.WRequest;
import com.mac.ws.WResponse;

public interface WsPort {
	WResponse getAdjustment(WRequest request);
}
