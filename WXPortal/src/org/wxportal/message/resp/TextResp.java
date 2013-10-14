package org.wxportal.message.resp;

import java.util.Map;

public class TextResp extends AbstractBaseRespMessage {
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String handlerData2ReturnXml(Map<String, Object> requestMap) {
		return null;
	}
}