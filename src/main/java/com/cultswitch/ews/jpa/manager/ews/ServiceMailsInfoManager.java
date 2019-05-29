package com.cultswitch.ews.jpa.manager.ews;

import java.util.HashMap;

public interface ServiceMailsInfoManager {
	HashMap<Short,HashMap<String,String>> getMailInfo();
}
