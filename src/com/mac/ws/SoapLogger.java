package com.mac.ws;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class SoapLogger {
	
	final static Logger LOGGER = Logger.getLogger("SoapLogger");
	
	
	public static void logRequest(Object object, JAXBContext jaxbContext) {
		
		System.out.println("logging request");
        try {
            log("Request received: {}", object, jaxbContext);
        } catch (JAXBException e) {
            LOGGER.log(Level.SEVERE, "Could not log incomming request. ");
        }
		
	}
	
    public static void logResponse(Object object, JAXBContext jaxbContext) {
        System.out.println("logging response ");
        
        try {
            log("Response sent: {}", object, jaxbContext);
        } catch (JAXBException e) {
        	LOGGER.log(Level.SEVERE, "Could not log outgoing request. ");
        }
    }
    
    private static void log(String message, Object object, JAXBContext jaxbContext)
            throws JAXBException {

        if (jaxbContext == null) {
            LOGGER.log(Level.SEVERE, "JAXBContext cannot be null");
            return;
        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);

        OutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(object, os);

        LOGGER.log(Level.INFO, os.toString());
    }
}
