package org.wxportal.dbservice.client;

import java.util.ArrayList;

import org.wxportal.dao.WXAccountDAO;
import org.wxportal.dao.bean.WXAccountBean;

/**
 * 微信账号相关
 * 
 * @author HanWei 2013/10/09
 * 
 */
public class WXAccountDBService {

	private WXAccountDAO dao = new WXAccountDAO();

	/**
	 * 判断微信账号是否存在
	 * 
	 * @param column
	 *            :取值范围：name，orgid，wxnumber，token
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean isWXAccountExist(String column, String value) {
		boolean bFlag = true;
		ArrayList<WXAccountBean> list = new ArrayList<WXAccountBean>();
		list = (ArrayList<WXAccountBean>) dao.query("WXAccountBean",
				new String[] { column }, new String[] { value }, 0, 0);
		if (list.size() > 0)
			bFlag = false;
		return bFlag;
	}

	/**
	 * 新增一个微信账号
	 * 
	 * @param wxaccount
	 */
	public int addWXAccount(WXAccountBean wxaccount) {
		return dao.save(wxaccount);
	}

	/**
	 * 依据id删除一个对象
	 * 
	 * @param id
	 * @return
	 */
	public boolean delWXAccount(int id) {
		return dao.delete(WXAccountBean.class, id);
	}

	/**
	 * 删除多条记录
	 * 
	 * @param ids
	 * @return
	 */
	public boolean delWXAccounts(int[] ids) {
		boolean bFlag = true;
		for (int i = 0; i < ids.length; i++) {
			if (!dao.delete(ids[i])) {
				bFlag = false;
				System.err.println("删除第" + i + "个记录出错了！");
				break;
			}
		}
		return bFlag;
	}

	/**
	 * 依据条件删除对象
	 * 
	 * @param WXAccountBean
	 * @param columns
	 * @param values
	 * @return
	 */
	public boolean delWXAccountByValues(String WXAccountBean, String[] columns,
			String[] values) {
		return dao.delByValue(WXAccountBean, columns, values);
	}

	/**
	 * 更新一个微信账号信息
	 * 
	 * @param wxaccount
	 */
	public void updateWXAccount(WXAccountBean wxaccount) {
		dao.update(wxaccount);
	}

	/**
	 * 依据条件更新对象
	 * 
	 * @param object
	 *            ：要更新的对象
	 * @param columns
	 *            ：属性的数组
	 * @param values
	 *            ：属性对应的值
	 * @param whereCause
	 *            ：where条件
	 */
	public void updateWXAccountByValue(String WXAccountBean, String[] columns,
			String[] values, String whereCause) {
		dao.updateByValue(WXAccountBean, columns, values, whereCause);
	}

	/**
	 * 依据id查询一个user
	 * 
	 * @param id
	 * @return
	 */
	public WXAccountBean queryWXAccount(int id) {
		return dao.queryOne(id);
	}

	/**
	 * 依据条件查询WXAccount结果集
	 * 
	 * @param userid
	 *            :-1表示查询全部的微信账号，page为0是不分页查询，page大于0时会进行分页查询
	 * @param columns
	 * @param values
	 * @return
	 */
	public ArrayList<WXAccountBean> queryWXAccounts(int userId, int page,
			int pageSize) {
		return dao.queryWXAccounts(userId, page, pageSize);
	}

	public WXAccountDAO getDao() {
		return dao;
	}

	public void setDao(WXAccountDAO dao) {
		this.dao = dao;
	}
}
