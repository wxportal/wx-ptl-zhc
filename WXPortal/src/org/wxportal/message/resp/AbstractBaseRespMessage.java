package org.wxportal.message.resp;

import java.util.List;

public abstract class AbstractBaseRespMessage {

	/**
	 * Handler the request and translate the result to XML string
	 * 
	 * @param mes
	 * @return
	 */
	public abstract String handlerData2ReturnXml(List<Object> dbResultList,
			AbstractBaseRespMessage response);

	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType;

	// private int FuncFlag;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	// public int getFuncFlag() {
	// return FuncFlag;
	// }
	//
	// public void setFuncFlag(int funcFlag) {
	// FuncFlag = funcFlag;
	// }
}
