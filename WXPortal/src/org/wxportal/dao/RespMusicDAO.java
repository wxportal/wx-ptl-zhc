package org.wxportal.dao;

import java.util.List;

import org.wxportal.dao.bean.RespMusicBean;
import org.wxportal.dao.hibernate.HibernateBasicMethod;

/**
 * 音乐信息处理
 * @author HanWei
 *
 */
public class RespMusicDAO extends DAOFactory {

	HibernateBasicMethod baseMethod = new HibernateBasicMethod();

	/**
	 * 新增
	 * @param Object
	 */
	@Override
	public int add(Object object){
		RespMusicBean bean = (RespMusicBean)object;
		try {
			bean = (RespMusicBean)baseMethod.save(bean);
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
		return baseMethod.delete(RespMusicBean.class,id);
	}
	
	/**
	 * 删除满足条件的记录
	 * @param RespMusicBean
	 * @param columns
	 * @param values
	 */
	@Override
	public boolean delByValue(Object RespMusicBean,String[] columns,String[] values){
		return baseMethod.delByValue(RespMusicBean, columns, values);
	}
	
	/**
	 * 更新一个对象
	 * @param object
	 */
	@Override
	public void update(Object object){
		RespMusicBean bean = (RespMusicBean)object;
		baseMethod.update(bean);
	}
	
	/**
	 * 更新满足条件的记录
	 * @param RespMusicBean
	 * @param columns
	 * @param values
	 * @param whereCause
	 */
	@Override
	public void updateByValue(Object RespMusicBean,String[] columns,String[] values,String whereCause){
		baseMethod.updateValue(RespMusicBean, columns, values, whereCause);
	}
	
	/**
	 * 查询一个对象
	 * @param id
	 */
	@Override
	public RespMusicBean query(int id){
		return (RespMusicBean)baseMethod.queryOne(RespMusicBean.class, id);
	}
	
	/**
	 * 查询满足条件的集合
	 * @param RespMusicBean
	 * @param columns
	 * @param values
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List querysByValue(Object object,String[] columns,String[] values,int page,int pageSize){
		RespMusicBean bean = (RespMusicBean)object;
		return  baseMethod.query(bean, columns, values,page,pageSize);
	}

	@Override
	public List querys(int wxAccountId, int page, int pageSize) {
		String whereCause = " where wxAccountId = "+wxAccountId;
		return baseMethod.queryByCondition("RespMusicBean", whereCause, page, pageSize);
	}
	
	/**
	 *依据拼接好的条件查询
	 */
	@Override
	public List queryByCondition(Object object, String whereCause, int page,
			int pageSize) {
		return baseMethod.queryByCondition("RespMusicBean", whereCause, page, pageSize);
	}
	
	public HibernateBasicMethod getBaseMethod() {
		return baseMethod;
	}

	public void setBaseMethod(HibernateBasicMethod baseMethod) {
		this.baseMethod = baseMethod;
	}
}

