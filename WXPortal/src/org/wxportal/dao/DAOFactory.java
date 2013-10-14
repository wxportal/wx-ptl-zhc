package org.wxportal.dao;

import java.util.List;

import org.wxportal.dao.bean.RespImageBean;

/**
 * 
 * @author HanWei 2013/10/11
 *
 */
public abstract class DAOFactory {
	
    /**
     * 新增
     * @param object
     * @return
     */
	public abstract int add(Object object);

	/**
	 * 删除
	 * @param respImage
	 */
	public abstract boolean delete(int id);
	
	/**
	 * 删除满足条件的记录
	 * @param RespImageBean
	 * @param columns
	 * @param values
	 */
	public abstract boolean delByValue(Object RespImageBean,String[] columns,String[] values);
	
	/**
	 * 更新一个对象
	 * @param object
	 */
	public abstract void update(Object object);
	
	/**
	 * 更新满足条件的记录
	 * @param object
	 * @param columns
	 * @param values
	 * @param whereCause
	 */
	public abstract void updateByValue(Object object,String[] columns,String[] values,String whereCause);
	
	/**
	 * 查询一个对象
	 * @param id
	 */
	public abstract Object query(int id);
	
	/**
	 * 查询满足条件的集合
	 * @param Object
	 * @param columns
	 * @param values
	 */
	public abstract List querysByValue(Object Object,String[] columns,String[] values,int page,int pageSize);
	
	/**
	 * 查询微信账号下的信息
	 * @param wxAccountId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public abstract List querys(int wxAccountId,int page,int pageSize);
	
	/**
	 * 依据拼接好的条件查询
	 * @param object
	 * @param whereCause
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public abstract List queryByCondition(Object object,String whereCause,int page,int pageSize);
	
	
}

