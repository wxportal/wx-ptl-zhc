package org.wxportal.dao.bean;

/**
 * 回复新闻信息
 * @author HanWei
 *
 */
public class RespNewsBean {
	
	private int id;//标示唯一主键
	
	private String reqKey;//请求的Key
	
	private String title;//新闻标题
	
	private String description;//新闻内容
	
	private String picUrl;//新闻图片地址
	
	private String linkUrl;//新闻地址
	
	private int wxAccountId;//关联微信的ID

	public RespNewsBean(){}
	
	public RespNewsBean(int id, String reqKey, String title, String description,
			String picUrl, String linkUrl, int wxAccountId) {
		super();
		this.id = id;
		this.reqKey = reqKey;
		this.title = title;
		this.description = description;
		this.picUrl = picUrl;
		this.linkUrl = linkUrl;
		this.wxAccountId = wxAccountId;
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


	public int getWxAccountId() {
		return wxAccountId;
	}

	public void setWxAccountId(int wxAccountId) {
		this.wxAccountId = wxAccountId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return description;
	}

	public void setDescribe(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

}
