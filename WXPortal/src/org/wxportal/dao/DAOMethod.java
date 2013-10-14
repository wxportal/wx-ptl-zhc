package org.wxportal.dao;


/**
 * 
 * @author HanWei 2013/10/11
 *
 */
public class DAOMethod {
	
	public DAOFactory getDAO(String type){
		DAOFactory dao = null;
		type = "Resp".concat(type.substring(0, 1).toUpperCase()).concat(type.substring(1, type.length())).concat("DAO");
		System.out.println(type);
		String s = DAOFactory.class.getName();
		String className =  s.substring(0, s.lastIndexOf(".")+1).concat(type);
		System.out.println(className);
		try {
			dao = (DAOFactory)Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dao;
	}
	
}
