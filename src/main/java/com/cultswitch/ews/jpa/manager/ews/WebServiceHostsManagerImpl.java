package com.cultswitch.ews.jpa.manager.ews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.jpa.model.ews.WebServiceHosts;
import com.cultswitch.ews.jpa.repository.ews.WebServiceHostsRepository;

@Component
public class WebServiceHostsManagerImpl implements WebServiceHostsManager{
	
	@Autowired
	private WebServiceHostsRepository webServiceHostsRepository;
	
	public WebServiceHosts findByHostIP(String hostIP) {
		return webServiceHostsRepository.findByHostIP(hostIP);
	}
}
