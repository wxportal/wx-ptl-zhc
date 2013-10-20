package org.wxportal.message.resp;

import java.util.List;

import org.wxportal.dao.bean.RespTextBean;
import org.wxportal.util.MessageUtil;

public class TextResp extends AbstractBaseRespMessage {
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String handlerData2ReturnXml(List<Object> dbResultList,
			AbstractBaseRespMessage response) {
		TextResp textResponse = new TextResp();
		textResponse = (TextResp) response;
		if ("true".equals(dbResultList.get(0).toString())
				|| "true" == dbResultList.get(0).toString()) {
			RespTextBean textObject = (RespTextBean) dbResultList.get(2);
			textResponse.setContent(textObject.getContent());
			return MessageUtil.textMessageToXml(textResponse);
		} else {
			textResponse.setContent("输入有误,请输入正确的指令。");
			return MessageUtil.textMessageToXml(textResponse);
		}
	}
}