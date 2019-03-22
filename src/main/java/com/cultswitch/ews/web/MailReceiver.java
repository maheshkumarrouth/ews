package com.cultswitch.ews.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cultswitch.ews.manager.EmailManager;

@RestController
@RequestMapping("/")
public class MailReceiver {
	
	@Autowired
	private EmailManager emailManager;
	
	@RequestMapping(value="/sentMail")
	public void sentMail(@RequestParam("to") String to,@RequestParam("subject") String subject) {
		emailManager.sentMail(to, subject, "hai");
	}
	
}
