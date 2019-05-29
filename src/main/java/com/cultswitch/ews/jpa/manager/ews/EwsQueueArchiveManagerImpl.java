package com.cultswitch.ews.jpa.manager.ews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.jpa.repository.ews.EwsQueueArchiveRepository;


@Component
public class EwsQueueArchiveManagerImpl implements EwsQueueArchiveManager{

	@Autowired
	private EwsQueueArchiveRepository ewsQueueArchiveRepository;
}
