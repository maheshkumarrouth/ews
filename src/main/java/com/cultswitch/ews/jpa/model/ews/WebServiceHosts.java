package com.cultswitch.ews.jpa.model.ews;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="WebServiceHosts",catalog="ews")
public class WebServiceHosts {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;

	@Column
	private String HostIP;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getHostIP() {
		return HostIP;
	}

	public void setHostIP(String hostIP) {
		HostIP = hostIP;
	}
	
	
}
