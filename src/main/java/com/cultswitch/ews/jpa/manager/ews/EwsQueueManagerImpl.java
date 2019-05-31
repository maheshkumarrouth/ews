package com.cultswitch.ews.jpa.manager.ews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.jpa.model.ews.EwsQueue;
import com.cultswitch.ews.jpa.repository.ews.EwsQueueRepository;

@Component
public class EwsQueueManagerImpl implements EwsQueueManager{
	
	@Autowired
	private EwsQueueRepository ewsQueueRepository;
	
	public EwsQueue save(EwsQueue ewsQueue) {
		return ewsQueueRepository.save(ewsQueue);
	}
}
