package com.cultswitch.ews.jpa.model.ews;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service_mails_info",catalog="ews")
public class ServiceMailsInfo {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Short id;
	
	@Column
	private String mail;
	
	@Column
	private String password;
	
	@Column
	private String status;
	
	@Column
	private Short smtpServerID;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getSmtpServerID() {
		return smtpServerID;
	}

	public void setSmtpServerID(Short smtpServerID) {
		this.smtpServerID = smtpServerID;
	}
	
	
	
}
