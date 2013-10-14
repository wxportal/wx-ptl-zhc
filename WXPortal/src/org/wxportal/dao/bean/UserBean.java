package org.wxportal.dao.bean;

/**
 * 用户信息
 * @author hanwei
 *
 */
public class UserBean {
	
	private int id;//唯一主键id
	
	private String nickName;//用户昵称
	
	private String passWord;//密码
	
	private String level;//用户VIP等级
	
	private String email;//用户email
	
	private String telphone;//电话
	
	private String addr;//用户地址
	
	private String beginTime;//生效时间
	
	private String endTime;//结束时间
	
	private String name;//用户真实姓名
	
	private String creditCard;//用户身份证号码

	public UserBean(){}
	
	public UserBean(int id, String nickName, String passWord, String level,
			String email, String telphone, String addr, String beginTime,
			String endTime, String name, String creditCard) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.passWord = passWord;
		this.level = level;
		this.email = email;
		this.telphone = telphone;
		this.addr = addr;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.name = name;
		this.creditCard = creditCard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
}
