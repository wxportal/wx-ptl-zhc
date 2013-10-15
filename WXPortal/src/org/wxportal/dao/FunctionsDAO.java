package org.wxportal.dao;

import java.util.ArrayList;

import org.wxportal.dao.bean.FunctionsBean;
import org.wxportal.dao.bean.WXAccountBean;
import org.wxportal.dao.hibernate.HibernateBasicMethod;

/**
 * 系统功能信息处理（系统自定义功能，可能不需要此类）
 * 
 * @author HanWei
 * 
 */
public class FunctionsDAO extends HibernateBasicMethod {

	/**
	 * 新增
	 * 
	 * @param functions
	 */
	public int add(FunctionsBean functions) {
		FunctionsBean bean = null;
		try {
			bean = (FunctionsBean) super.save(functions);
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
	 * @param functions
	 */
	public boolean delete(int id) {
		return super.delete(FunctionsBean.class, id);
	}

	/**
	 * 删除满足条件的记录
	 * 
	 * @param FunctionsBean
	 * @param columns
	 * @param values
	 */
	public boolean delByValue(Object FunctionsBean, String[] columns,
			String[] values) {
		return super.delByValue(FunctionsBean, columns, values);
	}

	/**
	 * 更新一个对象
	 * 
	 * @param functions
	 */
	public boolean update(FunctionsBean functions) {
		try {
			super.update(functions);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 更新满足条件的记录
	 * 
	 * @param FunctionsBean
	 * @param columns
	 * @param values
	 * @param whereCause
	 */
	public boolean updateByValue(Object FunctionsBean, String[] columns,
			String[] values, String whereCause) {
		try {
			super.updateValue(FunctionsBean, columns, values, whereCause);
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
	public FunctionsBean queryOne(int id) {
		return (FunctionsBean) super.queryOne(FunctionsBean.class, id);
	}

	/**
	 * 查询满足条件的集合
	 * 
	 * @param FunctionsBean
	 * @param columns
	 * @param values
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<FunctionsBean> query(Object FunctionsBean,
			String[] columns, String[] values, int page, int pageSize) {
		return (ArrayList<FunctionsBean>) super.query(FunctionsBean, columns,
				values, page, pageSize);
	}
}
