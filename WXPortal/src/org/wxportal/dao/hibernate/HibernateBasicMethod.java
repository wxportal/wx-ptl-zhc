package org.wxportal.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Hibernate 操作数据库的公共方法
 * 
 * @author hanwei 2013-09-15
 * 
 */
public class HibernateBasicMethod {

	// private Session session = HibernateSessionFactory.getSession();

	/**
	 * 保存一个对象
	 * 
	 * @param o
	 *            对象
	 */
	public Object save(Object o) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Object obj = null;
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		obj = o;
		session.close();
		return obj;
	}

	/**
	 * 依据ID删除删除一个对象
	 * 
	 * @param o
	 */
	public boolean delete(Class<?> clazz, Serializable id) {
		Session session = HibernateSessionFactory.getSession();
		boolean bFlag = false;
		session.beginTransaction();
		Object object = session.get(clazz, id);
		if (object != null) {
			session.delete(object);
			bFlag = true;
		}
		session.getTransaction().commit();
		session.close();
		return bFlag;
	}

	/**
	 * 删除制定表满足条件的记录
	 * 
	 * @param object
	 *            :是实例对象的类，如UserBean，而不是其对应的数据库表user,即缓存中的对象
	 * @param columns
	 *            ：对象的属性数组
	 * @param values
	 *            :对象的值数组 对象属性数组和属性值相互对应
	 */
	public boolean delByValue(Object object, String[] columns, String[] values) {
		Session session = HibernateSessionFactory.getSession();
		boolean bFlag = false;
		String hql = "";
		hql = "delete from " + object + " where ";
		for (int i = 0; i < columns.length; i++) {
			hql += columns[i] + " = '" + values[i] + "' and ";
		}
		hql = hql.substring(0, hql.lastIndexOf("and"));
		session.beginTransaction();
		Query query = session.createQuery(hql);
		int i = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		if (i > 0) {
			bFlag = true;
		}
		return bFlag;
	}

	/**
	 * 更新对象
	 * 
	 * @param o
	 */
	public void update(Object o) {
		Session session = HibernateSessionFactory.getSession();
		// if (session.getTransaction() == null) {
		session.beginTransaction();
		// }
		session.update(o);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 更新满足条件的对象
	 * 
	 * @param object
	 * @param columns
	 *            []
	 * @param values
	 *            []
	 */
	public void updateValue(Object object, String[] columns, String[] values,
			String whereCause) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "";
		hql = "update " + object + " set ";
		for (int i = 0; i < columns.length; i++) {
			hql += columns[i] + " = '" + values[i] + "' , ";
		}
		hql = hql.substring(0, hql.lastIndexOf(","));
		hql += "where " + whereCause;
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 依据主键id查询一个对象
	 * 
	 * @param object
	 * @param id
	 * @return
	 */
	public Object queryOne(Class<?> clazz, Serializable id) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Object object = session.get(clazz, id);
		session.close();
		return object;
	}

	/**
	 * 查询结果
	 * 
	 * @param object
	 *            :查询的表
	 * @param columns
	 *            ：查询的条件数组
	 * @param values
	 *            ：查询的条件值，和columns对应
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List query(Object object, String[] columns, String[] values,
			int page, int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "";
		hql = " from " + object + " where 1=1 ";
		for (int i = 0; i < columns.length; i++) {
			hql += " and " + columns[i] + " = '" + values[i] + "'";
		}
		List list = null;
		session.beginTransaction();
		Query query = session.createQuery(hql);
		if (page > 0) {
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/**
	 * 特殊情况：处理按照某一个字段是int类型的查询
	 * 
	 * @param object
	 * @param column
	 * @param value
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List query(Object object, String column, int value, int page,
			int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "";
		if (value == -1) {
			hql = " from " + object + "";
		} else {
			hql = " from " + object + " where " + column + " = " + value + " ";
		}
		List list = null;
		session.beginTransaction();
		Query query = session.createQuery(hql);
		if (page > 0) {
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/**
	 * 依据条件查询结果集
	 * 
	 * @param object
	 * @param whereCause
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List queryByCondition(Object object, String whereCause, int page,
			int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		List list = null;
		String hql = "";
		hql = " from " + object + " " + whereCause + "";
		session.beginTransaction();
		Query query = session.createQuery(hql);
		if (page > 0) {
			query.setFirstResult((page - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

}
