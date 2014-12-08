package com.mac.ws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WResponse {

	private String resCode;
	private String resMessage;
	private int counter;
	
	public String getResCode() {
		return resCode;
	}
	@XmlElement
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMessage() {
		return resMessage;
	}
	@XmlElement
	public void setResMessage(String resMessage) {
		this.resMessage = resMessage;
	}
	public int getCounter() {
		return counter;
	}
	@XmlElement
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}
