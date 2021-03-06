package com.cultswitch.ews.jpa.repository.ews;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cultswitch.ews.jpa.model.ews.EwsQueue;


@Repository
public interface EwsQueueRepository extends JpaRepository<EwsQueue, Integer>{

	@Transactional(readOnly =true)
	 List<EwsQueue> findAll();
	
	@Transactional(readOnly = true)
	 EwsQueue save(EwsQueue ewsQueue);
}
