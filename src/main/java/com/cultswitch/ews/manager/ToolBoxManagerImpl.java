package com.cultswitch.ews.manager;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.jpa.manager.ews.ServiceMailsInfoManager;

@Component
public class ToolBoxManagerImpl implements ToolBoxManager{
	
	private HashMap<Short,HashMap<String,String>> mailInfo = null;
	
	@Autowired
	private ServiceMailsInfoManager serviceMailsInfoManager;
	
	public HashMap<Short,HashMap<String,String>> getMailInfo(){
		if(mailInfo == null || mailInfo.isEmpty())
			this.loadMailInfo();
		return mailInfo;
	}
	
	
	public void loadMailInfo() {
		mailInfo = serviceMailsInfoManager.getMailInfo();
	}
}
