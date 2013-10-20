package org.wxportal.message.resp;

import java.util.List;

public class TextResp extends AbstractBaseRespMessage {
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String handlerData2ReturnXml(List<Object> dbResultList) {
		return null;
	}
}