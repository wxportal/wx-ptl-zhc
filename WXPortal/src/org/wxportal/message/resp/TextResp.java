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
		RespTextBean textObject = (RespTextBean) dbResultList.get(2);
		textResponse.setContent(textObject.getContent());
		return MessageUtil.textMessageToXml(textResponse);
	}
}