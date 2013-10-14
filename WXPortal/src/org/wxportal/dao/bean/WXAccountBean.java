package org.wxportal.dao.bean;

/**
 * 微信公共账号的相关信息
 * @author hanwei
 *
 */
public class WXAccountBean {

	private int id;//主键唯一id
	
	private UserBean user;//和UserBean关联
	
	private String name;//微信号名字，非空
	
	private String orgId;//微信组织机构ID，非空
	
	private String wxNumber;//微信号
	
	private String token;//请求参数token
	
	private String picUrl;//用户头像url
	
	private String area;//地区
	
	private String email;//公众号邮箱
	
	private String functions;//公众号具有的能力，或者叫此公众号的功能

	public WXAccountBean(){}
	
	public WXAccountBean(int id, UserBean user, String name, String orgId,
			String wxNumber, String token, String picUrl, String area,
			String email, String functions) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.orgId = orgId;
		this.wxNumber = wxNumber;
		this.token = token;
		this.picUrl = picUrl;
		this.area = area;
		this.email = email;
		this.functions = functions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getWxNumber() {
		return wxNumber;
	}

	public void setWxNumber(String wxNumber) {
		this.wxNumber = wxNumber;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFunctions() {
		return functions;
	}

	public void setFunctions(String functions) {
		this.functions = functions;
	}
	
}
