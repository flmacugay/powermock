package com.mac.ws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WRequest {
	
	private String id;
	private String transactionId;
	private String systemId;
	private int page;
	
	public String getId() {
		return id;
	}
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	public String getTransactionId() {
		return transactionId;
	}
	@XmlElement
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getSystemId() {
		return systemId;
	}
	@XmlElement
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	

}
