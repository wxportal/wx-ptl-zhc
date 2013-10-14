package org.wxportal.dbservice.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.wxportal.dao.CustomRespDAO;
import org.wxportal.dao.bean.CustomRespBean;
import org.wxportal.dao.hibernate.HibernateSessionFactory;


/**
 * 依据reqChar 和reqContent查询Type
 * @author HanWei
 *
 */
public class StringType {

	static CustomRespDAO dao = new CustomRespDAO();
	
	/**
	 * 依据请求参数查询回复的类型
	 * @param reqChar
	 * @param reqContent
	 * @param wxAccountId
	 * @return type+"@"+reqKey;
	 */
	public static String getType(String reqChar,String reqContent,int wxAccountId){
		
		Session session = HibernateSessionFactory.getSession();
		String hql = "";
		ArrayList<CustomRespBean> list = new ArrayList<CustomRespBean>();
		if("".equals(reqChar)&&!"".equals(reqContent)){
			hql = " from CustomRespBean b where b.reqContent = '"+reqContent+"' and b.wxAccount.id = "+wxAccountId;
		}else if (!"".equals(reqChar)&&"".equals(reqContent)) {
			hql = " from CustomRespBean b where b.reqChar = '"+reqChar+"' and b.wxAccount.id = "+wxAccountId;
		}else if(!"".equals(reqChar)&&!"".equals(reqContent)){
			hql = " from CustomRespBean b where b.reqChar = '"+reqChar+"' and b.reqContent = '"+reqContent+"' and b.wxAccount.id = "+wxAccountId;
		}else{
			return "";
		}
		session.beginTransaction();
		Query query = session.createQuery(hql);
		list = (ArrayList<CustomRespBean>)query.list();
		session.getTransaction().commit();
		session.close();
		String type = list.get(0).getRespType();
		String reqKey = list.get(0).getReqKey();
		return type+"@"+reqKey;
	}
	
	public CustomRespDAO getDao() {
		return dao;
	}
	
}
