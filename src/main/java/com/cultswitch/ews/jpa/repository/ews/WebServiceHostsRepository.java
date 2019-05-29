package com.cultswitch.ews.jpa.repository.ews;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cultswitch.ews.jpa.model.ews.WebServiceHosts;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface WebServiceHostsRepository extends JpaRepository<WebServiceHosts, Integer>{
	@Transactional(readOnly =true)
	public WebServiceHosts findByHostIP(String hostIP);
}
