package com.cultswitch.ews.jpa.manager.ews;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.jpa.model.ews.ServiceMailsInfo;
import com.cultswitch.ews.jpa.repository.ews.ServiceMailsInfoRepository;

@Component
public class ServiceMailsInfoManagerImpl implements ServiceMailsInfoManager{
	
	@Autowired
	private ServiceMailsInfoRepository serviceMailsInfoRepository;
	
	public HashMap<Short,HashMap<String,String>> getMailInfo(){
		HashMap<Short,HashMap<String,String>> mailInfo = new HashMap<>();
		List<ServiceMailsInfo> mailList = serviceMailsInfoRepository.findAll();
		if(mailList != null && !mailList.isEmpty()) {
			for(Iterator<ServiceMailsInfo> it = mailList.iterator();it.hasNext();) {
				ServiceMailsInfo serviceMailsInfo = it.next();
				if(serviceMailsInfo != null) {
					HashMap<String,String> mailAddress = mailInfo.get(serviceMailsInfo.getSmtpServerID());
					if(mailAddress == null) {
						mailAddress = new HashMap<String,String>();  
						mailInfo.put(serviceMailsInfo.getSmtpServerID(), mailAddress);
					}
					mailAddress.put(serviceMailsInfo.getMail(), serviceMailsInfo.getPassword());
				}
			}
		}
		return mailInfo;
	}
	
	
}
