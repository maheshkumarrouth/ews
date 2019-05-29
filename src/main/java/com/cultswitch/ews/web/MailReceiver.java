package com.cultswitch.ews.web;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cultswitch.ews.manager.MailReaderManager;
import com.cultswitch.ews.services.EwsValidator;

@RestController
@RequestMapping("/ews")
public class MailReceiver {
	
	@Autowired
	private MailReaderManager mailReaderManager; 
	
	@Autowired
	private EwsValidator ewsValidator;
	
//	@RequestMapping(value="/sentMail")
//	public void sentMail(@RequestParam("to") String to,@RequestParam("subject") String subject) {
//		
//	}
	
	@RequestMapping(value="/readMail")
	public void readMail() {
		try {
			Folder folder = mailReaderManager.getInbox("bookings@cultuzz.com", "cX6Mu3xHN6GduBYC");
			mailReaderManager.pickAndProcessNewMail(folder);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/sentMail")
	public String receiveMail(@RequestParam("Mail_RQ") String mailRQ, HttpServletRequest request){
		return ewsValidator.validateEwsXml(mailRQ, request.getRemoteAddr());
	}
	
}
