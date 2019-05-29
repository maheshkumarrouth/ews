package com.cultswitch.ews.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.exceptions.EwsException;
import com.cultswitch.ews.jpa.manager.ews.WebServiceHostsManager;
import com.cultswitch.ews.jpa.model.ews.WebServiceHosts;

@Component
public class EwsValidatorImpl implements EwsValidator{
	
	@Autowired
	private WebServiceHostsManager webServiceHostsManager;
	
	public String validateEwsXml(String xml,String hostIP) {
		
		if(xml == null || !xml.startsWith("<"))
			throw new EwsException("Invalid Request", HttpStatus.BAD_REQUEST);
		
		WebServiceHosts webServiceHosts = webServiceHostsManager.findByHostIP(hostIP);
		if(webServiceHosts == null)
			throw new EwsException("UNAUTHORIZED ACCESS", HttpStatus.UNAUTHORIZED);
			
		return null;
		
	}
}
