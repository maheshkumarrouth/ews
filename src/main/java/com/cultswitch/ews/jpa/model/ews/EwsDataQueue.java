package com.cultswitch.ews.jpa.model.ews;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ewsDataQueue", catalog="ews")
public class EwsDataQueue {
	
	@Id
	@Column(name="ewsQueueId")
	private Integer ewsQueueId;
	
	@Column(name="ewsRq")
	private String ewsRq;

	public Integer getEwsQueueId() {
		return ewsQueueId;
	}

	public void setEwsQueueId(Integer ewsQueueId) {
		this.ewsQueueId = ewsQueueId;
	}

	public String getEwsRq() {
		return ewsRq;
	}

	public void setEwsRq(String ewsRq) {
		this.ewsRq = ewsRq;
	}
	
	

}
