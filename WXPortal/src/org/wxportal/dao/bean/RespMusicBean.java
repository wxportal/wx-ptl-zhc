package org.wxportal.dao.bean;

/**
 * 回复音乐信息
 * @author HanWei
 *
 */
public class RespMusicBean {
	
	private int id;//标示唯一主键
	
	private String reqKey;//请求的Key
	
	private String title;//音乐标题
	
	private String description;//音乐描述
	
	private String linkUrl;//音乐链接
	
	private String realUrl;//上传的音乐实际存储地址
	
	private int wxAccountId;//关联微信的ID

	public RespMusicBean(){}
	



	public RespMusicBean(int id, String reqKey, String title,
			String description, String linkUrl, String realUrl, int wxAccountId) {
		super();
		this.id = id;
		this.reqKey = reqKey;
		this.title = title;
		this.description = description;
		this.linkUrl = linkUrl;
		this.realUrl = realUrl;
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
