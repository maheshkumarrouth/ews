package com.cultswitch.ews.jpa.manager.ews;

import com.cultswitch.ews.jpa.model.ews.WebServiceHosts;

public interface WebServiceHostsManager {
	public WebServiceHosts findByHostIP(String hostIP);
}
