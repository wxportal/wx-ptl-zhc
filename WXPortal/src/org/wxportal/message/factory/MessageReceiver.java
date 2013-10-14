package org.wxportal.message.factory;

import java.util.Map;

public abstract class MessageReceiver {
	/**
	 * Abstract class for manager all receivers
	 * 
	 * @author Dawei Zhang
	 * @date 2012-10-04
	 */

	/**
	 * Get the object of request and return the object of response
	 * 
	 * @return
	 */
	public abstract String returnResp(Map<String, String> requestMap);

}
