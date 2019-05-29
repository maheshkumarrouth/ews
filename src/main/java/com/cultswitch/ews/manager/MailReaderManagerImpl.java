package com.cultswitch.ews.manager;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.springframework.stereotype.Component;

@Component
public class MailReaderManagerImpl implements MailReaderManager {

	public Folder getInbox(final String username, final String password) throws MessagingException {
		Session session = null;
		Store store = null;
		String host = "mail.jpberlin.de";
		session = Session.getInstance(new Properties(), null);
		store = session.getStore("imap");
		store.connect(host, username, password);
		return store.getFolder("INBOX");
	}
	
	public void pickAndProcessNewMail(final Folder folder) {
		FlagTerm flagTerm = null;
        Message messages[] = null;
        try {
        	if (folder != null && folder.exists()) {
        		System.out.println("folder.exists()"+folder.exists());
        		folder.open(Folder.READ_WRITE);
                flagTerm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
                messages = folder.search(flagTerm);
                if (messages != null && messages.length > 0) {
                	for (Message message : messages) {
                		folder.setFlags(messages, new Flags(Flags.Flag.SEEN), true);
                		Integer ewsID = this.readHeaders(message.getAllHeaders());
                        System.out.println(message.getSubject() + ewsID);
                        Object content = message.getContent();
                	}
                }
        	}
        }catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private Integer readHeaders(Enumeration headers) {
        Integer ewsID = null;
        if (headers != null) {

            Header header = null;
            Object tempObject = null;

            try {

                while (headers.hasMoreElements()) {
                    tempObject = headers.nextElement();
                    if (tempObject instanceof Header) {
                        header = (Header) tempObject;
                        if ("EWS-ID".equalsIgnoreCase(header.getName())) {
                            ewsID = Integer.parseInt(header.getValue());
                            return ewsID;
                        }

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                header = null;
                tempObject = null;
            }
        }
        return ewsID;
    }
	
	
	private void processBodyPart(Object content) {
		BufferedReader bufferedReader = null;
        StringReader stringReader = null;
        StringBuilder body = new StringBuilder();
		if (content != null) {
			try {
				String bodyContent = content.toString();
				stringReader = new StringReader(bodyContent);
                bufferedReader = new BufferedReader(stringReader);
                String line = bufferedReader.readLine();
                while (line != null) {
                	if (line.contains("Cultuzz-ID:")) {
                		line = line.split(":")[1].trim();
                	}
                	if (line.contains("Content-Transfer-Encoding: base64")) {
                        body.append("----- attachment truncated -----");
                        break;
                    }

                    body.append(line);
                    body.append('\n');
                    line = bufferedReader.readLine();
                }
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
