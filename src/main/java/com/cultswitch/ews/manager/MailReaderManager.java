package com.cultswitch.ews.manager;

import javax.mail.Folder;
import javax.mail.MessagingException;

public interface MailReaderManager {
	Folder getInbox(final String username, final String password) throws MessagingException;
	void pickAndProcessNewMail(final Folder folder);
}
