package org.wxportal.message.factory;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.wxportal.util.MessageUtil;

/**
 * Message deal factory
 * 
 * @author dawzhang
 * @date 2013-09-22
 * 
 */
public class MessageFactory {

	/**
	 * Return the XML String after handler request
	 * 
	 * @param request
	 * @return
	 */
	public static String getResult(HttpServletRequest request) {
		Map<String, String> requestMap = new HashMap<String, String>();
		String msgType = "";
		try {
			// get the message type
			requestMap = MessageUtil.parseXml(request);
			msgType = requestMap.get("MsgType");

			// create and find the type maker
			String typeStr = msgType.substring(0, 1).toUpperCase()
					+ msgType.substring(1);
			String className = MessageFactory.class.getPackage().getName()
					+ "." + typeStr + "Receiver";

			// new instance some object and get the result
			MessageReceiver maker = (MessageReceiver) Class.forName(className)
					.newInstance();
			return maker.returnResp(requestMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
