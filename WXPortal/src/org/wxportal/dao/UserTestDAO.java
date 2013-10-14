package org.wxportal.dao;

import org.wxportal.dbservice.service.QueryDBService;


public class UserTestDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//UserBeanTest u = new UserBeanTest();
		//u.setId("1");
		//u.setUsername("zhanghsan");
		//u.setPassword("ds123321");
		
		//增
		/*Session session = HibernateSessionFactory.getSeesion();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
		System.out.println("Success!");*/
		
		//删
		/*Session session = HibernateSessionFactory.getSeesion();
		String hql = "delete from UserBean where id = 1";
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();*/
		
		//HibernateBasicMethod hbm = new HibernateBasicMethod();
		//String ObjectName = "UserBean";
		//String Column = "username";
		//String Value = "11111";
		//String WhereCause = "id = 1";
		//改
		//hbm.updateValue(ObjectName, Column, Value,WhereCause);
		
		//查
		
		/*ArrayList<UserBean> list = (ArrayList<UserBean>)hbm.query(ObjectName, Column, Value);
		for(UserBean b:list){
			System.out.println(b.getUsername());
		}*/
		
/*		UserBean user = new UserBean();
		user.setId(1);
		user.setNickName("AAA");
		user.setPassWord("111");
		user.setLevel("1");
		
		WXAccountBean wx = new WXAccountBean();
		wx.setName("BBBB");
		wx.setOrgId("121121");
		wx.setUser(user);*/
		
		
		//Session session = HibernateSessionFactory.getSeesion();

		//未封装的直接session用法
		/*session.beginTransaction();
		session.save(wx);
		session.getTransaction().commit();
		session.close();
		System.out.println("Success!");*/
/*		ArrayList<WXAccountBean> list = new ArrayList<WXAccountBean>();
		session.beginTransaction();
		String hql = "from WXAccountBean where id = 1";
		Query query = session.createQuery(hql);
		list = (ArrayList<WXAccountBean>)query.list();
		session.getTransaction().commit();
		session.close();
			
			for(WXAccountBean s:list){
				System.out.println("ssss"+s.getName());
				System.out.println("nickName:----"+s.getUser().getNickName());
			}
			*/
		
	//封装好的方法，取得一个对象	
	/*	WXAccountDAO w = new WXAccountDAO();
		WXAccountBean bean = new WXAccountBean();
		bean = w.queryOne(bean, 1);
		System.out.println(":----"+bean.getName());
		System.out.println("nickName:----"+bean.getUser().getNickName());
		*/
		
		
		//封装好的方法，取得满足条件的集合，更新 删除 雷同
		/*
		WXAccountDAO w = new WXAccountDAO();
		ArrayList<WXAccountBean> list = new ArrayList<WXAccountBean>();
		String [] columns = new String[1];
		columns[0] = "id";
		String []values = new String[1];
		values[0] = "1";
		list = (ArrayList<WXAccountBean>)w.query("WXAccountBean", columns, values);
		for(WXAccountBean s:list){
			System.out.println("ssss"+s.getName());
			System.out.println("nickName:----"+s.getUser().getNickName());
		}*/
		
		/*UserDBService u = new UserDBService();
		//u.delUser(1);
		u.queryUser(2);*/
		
		/*UserBean user = new UserBean();
		user.setNickName("sssss");
		user.setPassWord("123321");
		//user.setLevel("2");
		UserDAO dao = new UserDAO();
		int i = dao.saveUser(user);
		System.out.print("i==========="+i);*/
		
		
		/*ObjectDBService service = new ObjectDBService();
		RespImageBean bean = new RespImageBean();
		bean.setContent("1111");
		bean.setWxAccountId(1);
		bean.setReqKey("111");
		service.delete(1, "image");*/
		
		//System.out.print(StringType.getType("1", "", 1));
		QueryDBService d = new QueryDBService();
		d.queryInfo("1", "1", 1);
	}

}
