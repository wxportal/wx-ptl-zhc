package org.wxportal.service;

import javax.servlet.http.HttpServletRequest;

import org.wxportal.message.factory.MessageFactory;

/**
 * Core service
 * 
 * @author dawzhang
 * @date 2013-09-23
 */
public class CoreService {
	/**
	 * deal with the request message from WeiXin
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		respMessage = MessageFactory.getResult(request);
		return respMessage;
	}
}
