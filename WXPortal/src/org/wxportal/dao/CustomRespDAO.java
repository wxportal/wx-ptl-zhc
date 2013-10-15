package org.wxportal.dao;

import java.util.ArrayList;

import org.wxportal.dao.bean.CustomRespBean;
import org.wxportal.dao.hibernate.HibernateBasicMethod;

/**
 * 用户自定义回复处理
 * 
 * @author HanWei
 * 
 */
public class CustomRespDAO extends HibernateBasicMethod {

	/**
	 * 新增
	 * 
	 * @param customResp
	 */
	public int save(CustomRespBean customResp) {
		CustomRespBean bean = null;
		try {
			bean = (CustomRespBean) super.save(customResp);
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
	 * @param customResp
	 */
	public boolean delete(int id) {
		return super.delete(CustomRespBean.class, id);
	}

	/**
	 * 删除满足条件的记录
	 * 
	 * @param CustomRespBean
	 * @param columns
	 * @param values
	 */
	public boolean delByValue(Object CustomRespBean, String[] columns,
			String[] values) {
		return super.delByValue(CustomRespBean, columns, values);
	}

	/**
	 * 更新一个对象
	 * 
	 * @param customResp
	 */
	public boolean update(CustomRespBean customResp) {
		try {
			super.update(customResp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 更新满足条件的记录
	 * 
	 * @param CustomRespBean
	 * @param columns
	 * @param values
	 * @param whereCause
	 */
	public boolean updateByValue(Object CustomRespBean, String[] columns,
			String[] values, String whereCause) {
		try {
			super.updateValue(CustomRespBean, columns, values, whereCause);
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
	public CustomRespBean queryOne(int id) {
		return (CustomRespBean) super.queryOne(CustomRespBean.class, id);
	}

	/**
	 * 查询满足条件的集合
	 * 
	 * @param CustomRespBean
	 * @param columns
	 * @param values
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<CustomRespBean> query(Object CustomRespBean,
			String[] columns, String[] values, int page, int pageSize) {
		return (ArrayList<CustomRespBean>) super.query(CustomRespBean, columns,
				values, page, pageSize);
	}

	/**
	 * 依据条件查询结果集
	 * 
	 * @param CustomRespBean
	 * @param whereCause
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<CustomRespBean> queryCondition(Object CustomRespBean,
			String whereCause, int page, int pageSize) {
		return (ArrayList<CustomRespBean>) super.queryByCondition(
				CustomRespBean, whereCause, page, pageSize);
	}
}
