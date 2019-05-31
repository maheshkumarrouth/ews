package com.cultswitch.ews.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.exceptions.EwsException;
import com.cultswitch.ews.jpa.manager.ews.WebServiceHostsManager;
import com.cultswitch.ews.jpa.model.ews.WebServiceHosts;
import com.cultswitch.ews.manager.MailRecevierManager;
import com.cultswitch.ews.manager.ToolBoxManager;

@Component
public class EwsValidatorImpl implements EwsValidator{
	
	@Autowired
	private WebServiceHostsManager webServiceHostsManager;
	
	@Autowired
	private MailRecevierManager mailRecevierManager;
	
	@Autowired
	private ToolBoxManager toolBoxManager;
	
	public String validateEwsXml(String xml,String hostIP) {
		
		if(xml == null || !xml.startsWith("<"))
			throw new EwsException(toolBoxManager.getXMLForErrorMsg("Invalid Request"), HttpStatus.BAD_REQUEST);
		
		WebServiceHosts webServiceHosts = webServiceHostsManager.findByHostIP(hostIP);
		if(webServiceHosts == null)
			throw new EwsException(toolBoxManager.getXMLForErrorMsg("UNAUTHORIZED ACCESS"), HttpStatus.UNAUTHORIZED);
		
		return mailRecevierManager.receiveMail(xml);
	}
}
