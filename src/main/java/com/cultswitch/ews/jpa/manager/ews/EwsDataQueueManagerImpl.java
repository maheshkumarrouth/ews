package com.cultswitch.ews.jpa.manager.ews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.jpa.model.ews.EwsDataQueue;
import com.cultswitch.ews.jpa.repository.ews.EwsDataQueueRepository;


@Component
public class EwsDataQueueManagerImpl implements EwsDataQueueManager{
	
	@Autowired
	private EwsDataQueueRepository ewsDataQueueRepository;
	

	public EwsDataQueue save(EwsDataQueue ewsDataQueue) {
		return ewsDataQueueRepository.save(ewsDataQueue);
	}
}
