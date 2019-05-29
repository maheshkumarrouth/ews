package com.cultswitch.ews.jpa.model.ews;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ewsQueueArchive", catalog="ews")
public class EwsQueueArchive {
	
	@Id
	@Column(name="ewsQueueId")
	private Integer ewsQueueId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="inTime")
	private Date inTime;
	
	@Column(name="outTime")
	private Date outTime;

	public Integer getEwsQueueId() {
		return ewsQueueId;
	}

	public void setEwsQueueId(Integer ewsQueueId) {
		this.ewsQueueId = ewsQueueId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	
	

}
