package com.cultswitch.ews.jpa.repository.ews;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cultswitch.ews.jpa.model.ews.ServiceMailsInfo;

@Repository
public interface ServiceMailsInfoRepository extends JpaRepository<ServiceMailsInfo,Short>{
	
	@Transactional(readOnly =true)
	 List<ServiceMailsInfo> findAll();
	
}
