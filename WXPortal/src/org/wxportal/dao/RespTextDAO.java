package org.wxportal.dao;

import java.util.List;

import org.wxportal.dao.bean.RespTextBean;
import org.wxportal.dao.hibernate.HibernateBasicMethod;

/**
 * 文本信息处理
 * @author HanWei
 *
 */
public class RespTextDAO extends DAOFactory {

	HibernateBasicMethod baseMethod = new HibernateBasicMethod();

	/**
	 * 新增
	 * @param Object
	 */
	@Override
	public int add(Object object){
		RespTextBean bean = (RespTextBean)object;
		try {
			bean = (RespTextBean)baseMethod.save(bean);
			return bean.getId();
		} catch (Exception e) {
			System.out.println("保存时发生错误！");
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@Override
	public boolean delete(int id){
		return baseMethod.delete(RespTextBean.class,id);
	}
	
	/**
	 * 删除满足条件的记录
	 * @param RespTextBean
	 * @param columns
	 * @param values
	 */
	@Override
	public boolean delByValue(Object RespTextBean,String[] columns,String[] values){
		return baseMethod.delByValue(RespTextBean, columns, values);
	}
	
	/**
	 * 更新一个对象
	 * @param object
	 */
	@Override
	public void update(Object object){
		RespTextBean bean = (RespTextBean)object;
		baseMethod.update(bean);
	}
	
	/**
	 * 更新满足条件的记录
	 * @param RespTextBean
	 * @param columns
	 * @param values
	 * @param whereCause
	 */
	@Override
	public void updateByValue(Object RespTextBean,String[] columns,String[] values,String whereCause){
		baseMethod.updateValue(RespTextBean, columns, values, whereCause);
	}
	
	/**
	 * 查询一个对象
	 * @param id
	 */
	@Override
	public RespTextBean query(int id){
		return (RespTextBean)baseMethod.queryOne(RespTextBean.class, id);
	}
	
	/**
	 * 查询满足条件的集合
	 * @param RespTextBean
	 * @param columns
	 * @param values
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List querysByValue(Object object,String[] columns,String[] values,int page,int pageSize){
		RespTextBean bean = (RespTextBean)object;
		return  baseMethod.query(bean, columns, values,page,pageSize);
	}

	@Override
	public List querys(int wxAccountId, int page, int pageSize) {
		String whereCause = " where wxAccountId = "+wxAccountId;
		return baseMethod.queryByCondition("RespTextBean", whereCause, page, pageSize);
	}
	
	/**
	 *依据拼接好的条件查询
	 */
	@Override
	public List queryByCondition(Object object, String whereCause, int page,
			int pageSize) {
		return baseMethod.queryByCondition("RespTextBean", whereCause, page, pageSize);
	}
	
	
	public HibernateBasicMethod getBaseMethod() {
		return baseMethod;
	}

	public void setBaseMethod(HibernateBasicMethod baseMethod) {
		this.baseMethod = baseMethod;
	}
}
