package org.wxportal.message.factory;

import java.util.List;
import java.util.Map;

import org.wxportal.dao.bean.RespTextBean;
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
		if ("false".equals(dbResultList.get(0).toString())
				|| "false" == dbResultList.get(0).toString()) {
			dbResultList.clear();
			dbResultList.add(false);
			dbResultList.add("Text");
			dbResultList.add(new RespTextBean(0, "", "输入有误,请输入正确的指令.", 0));
		}
		try {
			className = AbstractBaseRespMessage.class.getPackage().getName()
					+ "." + dbResultList.get(1).toString() + "Resp";
			AbstractBaseRespMessage response = (AbstractBaseRespMessage) Class
					.forName(className).newInstance();
			response.setCreateTime(System.currentTimeMillis());
			response.setFromUserName(requestMap.get("ToUserName"));
			response.setToUserName(senderName);
			response.setMsgType(dbResultList.get(1).toString());
			if (dbResultList.size() >= 3)
				return response.handlerData2ReturnXml(dbResultList, response);
			else
				return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}
}
