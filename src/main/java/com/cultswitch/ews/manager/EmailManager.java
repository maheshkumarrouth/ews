package com.cultswitch.ews.manager;

public interface EmailManager {
	
	 void sentMail(String to, String subject, String text);
	 
}
