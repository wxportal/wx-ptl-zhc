package org.wxportal.dao;

import java.util.ArrayList;

import org.wxportal.dao.bean.WXAccountBean;
import org.wxportal.dao.hibernate.HibernateBasicMethod;

/**
 * 微信账号处理
 * @author HanWei
 *
 */
public class WXAccountDAO extends HibernateBasicMethod {
	
	/**
	 * 新增
	 * @param wxaccount
	 */
	public int save(WXAccountBean wxaccount){
		WXAccountBean bean = null;
		try {
			bean = (WXAccountBean)super.save(wxaccount);
			return bean.getId();
		} catch (Exception e) {
			System.out.println("保存时发生错误！");
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 删除一个wxaccount对象
	 * @param wxaccount
	 */
	public boolean delete(int id){
		return super.delete(WXAccountBean.class,id);
	}
	
	/**
	 * 按照指定的条件删除wxaccount对象
	 * @param wxaccount
	 * @param columns
	 * @param values
	 */
	public boolean delByValue(Object WXAccountBean,String[] columns,String[] values){
		return super.delByValue(WXAccountBean, columns, values);
	}
	
	/**
	 * 更新一个对象
	 * @param wxaccount
	 */
	public boolean update(WXAccountBean wxaccount){
		try{
			super.update(wxaccount);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 按照条件更新对象列的值
	 * @param wxaccount
	 * @param columns
	 * @param values
	 * @param whereCause
	 */
	public boolean updateByValue(Object WXAccountBean,String[] columns,String[] values,String whereCause){
		try{
			super.updateValue(WXAccountBean, columns, values, whereCause);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 查询主键为ID的一个对象
	 * @param wxaccount
	 * @param id
	 * @return
	 */
	public  WXAccountBean queryOne(int id){
		return (WXAccountBean)super.queryOne(WXAccountBean.class, id);
	}
	
	/**
	 * 查询满足条件的结果集
	 * @param wxaccount
	 * @param columns
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<WXAccountBean> query(Object WXAccountBean,String[] columns,String[] values,int page,int pageSize){
		return (ArrayList<WXAccountBean>)super.query(WXAccountBean, columns, values,page,pageSize);
	}
	
	/**
	 * 查询用户下的微信账号
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ArrayList<WXAccountBean> queryWXAccounts(int userId,int page,int pageSize){
		return (ArrayList<WXAccountBean>)super.query("WXAccountBean", "user.id", userId, page, pageSize);
	}

}
