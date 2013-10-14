package org.wxportal.message.factory;

import java.util.Map;

import org.wxportal.message.db.DBAction;
import org.wxportal.message.resp.AbstractBaseRespMessage;

public class TextReceiver extends MessageReceiver {
	/**
	 * TextReceiver
	 * 
	 * @author Dawei Zhang
	 * @date 2012-10-04
	 */

	@Override
	public String returnResp(Map<String, String> requestMap) {

		String senderName = requestMap.get("FromUserName");
		String content = requestMap.get("Content");
		Map<String, Object> dbResultMap = DBAction.getRespTypeAndContent(
				senderName, content);
		String className = AbstractBaseRespMessage.class.getPackage().getName()
				+ "." + dbResultMap.get("ReturnType") + "Resp";
		try {
			AbstractBaseRespMessage response = (AbstractBaseRespMessage) Class
					.forName(className).newInstance();
			response.setCreateTime(System.currentTimeMillis());
			response.setFromUserName(requestMap.get("ToUserName"));
			response.setToUserName(senderName);
			response.setMsgType(dbResultMap.get("ReturnType").toString());
			return response.handlerData2ReturnXml(dbResultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}
}
