package com.cultswitch.ews.manager;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultswitch.ews.jpa.manager.ews.ServiceMailsInfoManager;

@Component
public class ToolBoxManagerImpl implements ToolBoxManager{
	
	private HashMap<Short,HashMap<String,String>> mailInfo = null;
	
	@Autowired
	private ServiceMailsInfoManager serviceMailsInfoManager;
	
	public HashMap<Short,HashMap<String,String>> getMailInfo(){
		if(mailInfo == null || mailInfo.isEmpty())
			this.loadMailInfo();
		return mailInfo;
	}
	
	
	public void loadMailInfo() {
		mailInfo = serviceMailsInfoManager.getMailInfo();
	}
	
	public String getRecevierXML(Integer id) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		sb.append("	 <Mail_Response>\n");
		sb.append("	  <Success/>\n");
		sb.append("		<Mail_Id>").append(id).append("</Mail_Id>\n");
		sb.append("	 </Mail_Response>");
		
		return sb.toString();
	}
	
	public String getXMLForErrorMsg(String errmsg) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<Mail_Response>\n");
		sb.append("   <Error>\n");
		sb.append("     <Message>\n");
		sb.append("         <![CDATA[").append(errmsg).append("]]>\n");
		sb.append("     </Message>\n");
		sb.append("   </Error>\n");
		sb.append("</Mail_Response>");
		
		return sb.toString();
	}
}
