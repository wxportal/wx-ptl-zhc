package org.wxportal.message.factory;

import java.util.List;
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
		List<Object> dbResultList = DBAction.getRespTypeAndContent(senderName,
				content);
		String className = "";
		boolean dbSearchSuccessFlag = false;
		if (dbResultList.size() < 3) {
			className = AbstractBaseRespMessage.class.getPackage().getName()
					+ "." + "Text" + "Resp";
		} else {
			dbSearchSuccessFlag = true;
			className = AbstractBaseRespMessage.class.getPackage().getName()
					+ "." + dbResultList.get(1).toString() + "Resp";
		}
		try {
			AbstractBaseRespMessage response = (AbstractBaseRespMessage) Class
					.forName(className).newInstance();
			response.setCreateTime(System.currentTimeMillis());
			response.setFromUserName(requestMap.get("ToUserName"));
			response.setToUserName(senderName);
			if (dbSearchSuccessFlag) {
				response.setMsgType(dbResultList.get(1).toString());
			} else {
				className = AbstractBaseRespMessage.class.getPackage()
						.getName() + "." + "Text" + "Resp";
			}
			return response.handlerData2ReturnXml(dbResultList, response);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}
}
