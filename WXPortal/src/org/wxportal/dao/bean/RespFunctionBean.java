package org.wxportal.dao.bean;

/**
 * 回复功能信息
 * @author HanWei
 *
 */
public class RespFunctionBean {
	
	private int id;//标示唯一主键
	
	private String reqKey;//请求的Key
	
	private String Content;//回复的内容
	
	private int wxAccount;//此定义关联的微信号
	
	
	public RespFunctionBean(){}
	
	public RespFunctionBean(int id, String reqKey, String content,
			int wxAccount) {
		super();
		this.id = id;
		this.reqKey = reqKey;
		Content = content;
		this.wxAccount = wxAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReqKey() {
		return reqKey;
	}

	public void setReqKey(String reqKey) {
		this.reqKey = reqKey;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getWxAccount() {
		return wxAccount;
	}

	public void setWxAccount(int wxAccount) {
		this.wxAccount = wxAccount;
	}

}
