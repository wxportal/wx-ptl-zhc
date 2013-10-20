package org.wxportal.message.resp;

import java.util.List;

import org.wxportal.dao.bean.RespTextBean;

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
		if ("true".equals(dbResultList.get(0).toString())
				|| "true" == dbResultList.get(0).toString()) {
			RespTextBean textObject = (RespTextBean) dbResultList.get(2);
			return null;
		} else {
			return "输入有误,请输入正确的指令。";
		}
	}
}