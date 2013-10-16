package org.wxportal.dao;

import java.util.List;

import org.wxportal.dao.bean.RespImageBean;
import org.wxportal.dao.hibernate.HibernateBasicMethod;

/**
 * 图片信息处理
 * 
 * @author HanWei
 * 
 */
public class RespImageDAO extends DAOFactory {

	HibernateBasicMethod baseMethod = new HibernateBasicMethod();

	/**
	 * 新增
	 * 
	 * @param Object
	 */
	@Override
	public int add(Object object) {
		RespImageBean bean = (RespImageBean) object;
		try {
			bean = (RespImageBean) baseMethod.save(bean);
			return bean.getId();
		} catch (Exception e) {
			System.out.println("保存时发生错误！");
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@Override
	public boolean delete(int id) {
		return baseMethod.delete(RespImageBean.class, id);
	}

	/**
	 * 删除满足条件的记录
	 * 
	 * @param RespImageBean
	 * @param columns
	 * @param values
	 */
	@Override
	public boolean delByValue(Object RespImageBean, String[] columns,
			String[] values) {
		return baseMethod.delByValue(RespImageBean, columns, values);
	}

	/**
	 * 更新一个对象
	 * 
	 * @param object
	 */
	@Override
	public boolean update(Object object) {
		try {
			RespImageBean bean = (RespImageBean) object;
			baseMethod.update(bean);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 更新满足条件的记录
	 * 
	 * @param RespImageBean
	 * @param columns
	 * @param values
	 * @param whereCause
	 */
	@Override
	public boolean updateByValue(Object RespImageBean, String[] columns,
			String[] values, String whereCause) {
		try {
			baseMethod.updateValue(RespImageBean, columns, values, whereCause);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查询一个对象
	 * 
	 * @param id
	 */
	@Override
	public RespImageBean query(int id) {
		return (RespImageBean) baseMethod.queryOne(RespImageBean.class, id);
	}

	/**
	 * 查询满足条件的集合
	 * 
	 * @param RespImageBean
	 * @param columns
	 * @param values
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List querysByValue(String[] columns, String[] values,
			int page, int pageSize) {
		return baseMethod.query("RespImageBean", columns, values, page, pageSize);
	}

	@Override
	public List querys(int wxAccountId, int page, int pageSize) {
		String whereCause = " where wxAccountId = " + wxAccountId;
		return baseMethod.queryByCondition("RespImageBean", whereCause, page,
				pageSize);
	}

	/**
	 * 依据拼接好的条件查询
	 */
	@Override
	public List queryByCondition(String whereCause, int page,
			int pageSize) {
		return baseMethod.queryByCondition("RespImageBean", whereCause, page,
				pageSize);
	}

	public HibernateBasicMethod getBaseMethod() {
		return baseMethod;
	}

	public void setBaseMethod(HibernateBasicMethod baseMethod) {
		this.baseMethod = baseMethod;
	}
}
