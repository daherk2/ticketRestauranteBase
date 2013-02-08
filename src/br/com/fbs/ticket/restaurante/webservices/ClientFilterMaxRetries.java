package br.com.fbs.ticket.restaurante.webservices;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class ClientFilterMaxRetries extends ClientFilter{
    
	private final int MAX_RETRIES = 3;
    
	@Override
	public ClientResponse handle(ClientRequest cr)throws ClientHandlerException {
		int i =0;
		
		while(i <= MAX_RETRIES){
			try{
				return getNext().handle(cr);
			}catch(Exception e){
				Logger.getLogger("ClientFilterMaxRetries").log(Level.INFO, "Connection Timeout (" + cr.getURI() + "), will try " + (MAX_RETRIES - i) + " more time(s).", e);
			}
		}
		throw new ClientHandlerException("Connection retries limit exceeded.");
	}

}
