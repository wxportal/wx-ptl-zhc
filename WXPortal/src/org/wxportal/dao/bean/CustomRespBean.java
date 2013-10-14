package org.wxportal.dao.bean;

/**
 * 微信用户请求处理关系信息,用户自定义
 * @author hanwei
 *
 */
public class CustomRespBean {
	
	private int id;//主键唯一ID
	
	private String reqChar;//请求的标示符，如1、2...
	
	private String reqContent;//请求的内容，如‘菜单’等关键字
	
	private String respType;//后台配置信息是定义的类型，如是回复还是命令。。
	
	private String reqKey;//回复的具体内容对应的Key
	
	private WXAccountBean wxAccount;//此定义关联的微信号
	
	
	public CustomRespBean(){}
   /**
    * 构造方法
    * @param id
    * @param reqChar
    * @param reqContent
    * @param type
    * @param reqKey
    * @param wxAccount
    */
	public CustomRespBean(int id, String reqChar, String reqContent,
			String type, String reqKey, WXAccountBean wxAccount) {
		super();
		this.id = id;
		this.reqChar = reqChar;
		this.reqContent = reqContent;
		this.respType = type;
		this.reqKey = reqKey;
		this.wxAccount = wxAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReqChar() {
		return reqChar;
	}

	public void setReqChar(String reqChar) {
		this.reqChar = reqChar;
	}

	public String getReqContent() {
		return reqContent;
	}

	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}

	public String getRespType() {
		return respType;
	}

	public void setRespType(String respType) {
		this.respType = respType;
	}

	public String getReqKey() {
		return reqKey;
	}

	public void setReqKey(String reqKey) {
		this.reqKey = reqKey;
	}

	public WXAccountBean getWxAccount() {
		return wxAccount;
	}

	public void setWxAccount(WXAccountBean wxAccount) {
		this.wxAccount = wxAccount;
	}
}
