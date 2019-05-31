package com.cultswitch.ews.manager;

import java.util.HashMap;

public interface ToolBoxManager {
	HashMap<Short,HashMap<String,String>> getMailInfo();
	String getRecevierXML(Integer id);
	String getXMLForErrorMsg(String errmsg);
}
