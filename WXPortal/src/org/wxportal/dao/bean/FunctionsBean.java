package org.wxportal.dao.bean;

/**
 * 功能信息
 * @author Hanwei
 *
 */
public class FunctionsBean {

	private int id;//标识唯一主键的id
	
	private String functionId;//功能id
	
	private String name;//功能名字
	
	private String  pfId;//父功能ID
	
	private String cfId;//子节点功能ID
	
	public FunctionsBean(){}

	public FunctionsBean(int id, String functionId, String name, String pfId,
			String cfId) {
		super();
		this.id = id;
		this.functionId = functionId;
		this.name = name;
		this.pfId = pfId;
		this.cfId = cfId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPfId() {
		return pfId;
	}

	public void setPfId(String pfId) {
		this.pfId = pfId;
	}

	public String getCfId() {
		return cfId;
	}

	public void setCfId(String cfId) {
		this.cfId = cfId;
	}

	
}
