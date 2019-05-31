package com.cultswitch.ews.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.jpa.manager.ews.EwsDataQueueManager;
import com.cultswitch.ews.jpa.manager.ews.EwsQueueManager;
import com.cultswitch.ews.jpa.model.ews.EwsDataQueue;
import com.cultswitch.ews.jpa.model.ews.EwsQueue;

@Component
public class MailRecevierManagerImpl implements MailRecevierManager{
	
	@Autowired
	private EwsQueueManager ewsQueueManager;
	
	@Autowired
	private EwsDataQueueManager ewsDataQueueManager;
	
	@Autowired
	private ToolBoxManager toolBoxManager;
	

	public String receiveMail(String xml) {
		
		Date date = new Date();
		EwsQueue ewsQueue = new EwsQueue();
		ewsQueue.setStatus("0");
		ewsQueue.setInTime(date);
		EwsQueue queue = ewsQueueManager.save(ewsQueue);
		
		EwsDataQueue ewsDataQueue = new EwsDataQueue();
		ewsDataQueue.setEwsQueueId(queue.getId());
		ewsDataQueue.setEwsRq(xml);
		ewsDataQueueManager.save(ewsDataQueue);
		
		return toolBoxManager.getRecevierXML(queue.getId());
	}
}
