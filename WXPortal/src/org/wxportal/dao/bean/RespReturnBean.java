package org.wxportal.dao.bean;

/**
 * 用户已有配置的返回类型
 * @author Administrator
 *
 */
public class RespReturnBean {
	
	private String reqChar;
	
	private String reqContent;
	
	private String title;
	
	private String description;
	
	private String realUrl;
	
	private String linkUrl;
	
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getRealUrl() {
		return realUrl;
	}

	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}
	
	

}
