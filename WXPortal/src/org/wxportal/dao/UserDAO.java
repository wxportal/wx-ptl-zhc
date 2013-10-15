package org.wxportal.dao;

import java.util.ArrayList;

import org.wxportal.dao.bean.UserBean;
import org.wxportal.dao.hibernate.HibernateBasicMethod;

/**
 * 用户注册信息处理
 * 
 * @author Administrator
 * 
 */
public class UserDAO extends HibernateBasicMethod {

	/**
	 * 新增
	 * 
	 * @param user
	 */
	public int addUser(UserBean user) {
		try {
			UserBean u = (UserBean) super.save(user);
			return u.getId();
		} catch (Exception e) {
			System.out.println("保存时发生错误！");
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 依据id删除
	 * 
	 * @param user
	 */
	public boolean deleteUser(int id) {
		return super.delete(UserBean.class, id);
	}

	/**
	 * 依据条件删除
	 * 
	 * @param UserBean
	 *            ：缓存对象
	 * @param columns
	 *            ：列名
	 * @param values
	 *            ：值
	 */
	public boolean delUserByValues(String UserBean, String[] columns,
			String[] values) {
		return super.delByValue(UserBean, columns, values);
	}

	/**
	 * 更新
	 * 
	 * @param user
	 */
	public boolean updateUser(UserBean user) {
		try {
			super.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 更新满足的条件的记录
	 * 
	 * @param user
	 *            ：表名
	 * @param columns
	 *            ：列名
	 * @param values
	 *            :值
	 * @param whereCause
	 *            ：where 条件
	 */
	public boolean updateByValue(String UserBean, String[] columns,
			String[] values, String whereCause) {
		try {
			super.updateValue(UserBean, columns, values, whereCause);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 依据id查询一个对象
	 * 
	 * @param id
	 * @return
	 */
	public UserBean querUser(int id) {
		return (UserBean) super.queryOne(UserBean.class, id);
	}

	/**
	 * 查询
	 * 
	 * @param user
	 * @param columns
	 * @param values
	 * @return 返回用户信息结果集
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<UserBean> queryUsers(String userbean, String[] columns,
			String[] values, int page, int pageSize) {
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		list = (ArrayList<UserBean>) super.query(userbean, columns, values,
				page, pageSize);
		return list;
	}

}
