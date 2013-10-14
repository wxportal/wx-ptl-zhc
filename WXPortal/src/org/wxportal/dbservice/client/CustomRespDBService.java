package org.wxportal.dbservice.client;

import java.util.ArrayList;

import org.wxportal.dao.CustomRespDAO;
import org.wxportal.dao.bean.CustomRespBean;

/**
 * 微信账号相关
 * 
 * @author HanWei 2013/10/09
 * 
 */
public class CustomRespDBService {

	private CustomRespDAO dao = new CustomRespDAO();

	/**
	 * 判断微信账号是否存在
	 * 
	 * @param column
	 *            :取值范围：name，orgid，wxnumber，token
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean isCustomRespExist(String ColumnName, String ColumnValue,
			String wxAccountId) {
		boolean bFlag = true;
		String whereCause = " where " + ColumnName + " = '" + ColumnValue
				+ "' and wxAccountId = " + wxAccountId;
		ArrayList<CustomRespBean> list = new ArrayList<CustomRespBean>();
		list = (ArrayList<CustomRespBean>) dao.queryByCondition(
				"CustomRespBean", whereCause, 0, 0);
		if (list.size() > 0)
			bFlag = false;
		return bFlag;
	}

	/**
	 * 新增一个用户回复
	 * 
	 * @param wxaccount
	 */
	public int addCustomResp(CustomRespBean bean) {
		return dao.save(bean);
	}

	/**
	 * 依据id删除一个对象
	 * 
	 * @param id
	 * @return
	 */
	public boolean delCustomResp(int id) {
		return dao.delete(CustomRespBean.class, id);
	}

	/**
	 * 删除多条记录
	 * 
	 * @param ids
	 * @return
	 */
	public boolean delCustomResps(int[] ids) {
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
	public boolean delCustomRespValues(String CustomRespBean, String[] columns,
			String[] values) {
		return dao.delByValue(CustomRespBean, columns, values);
	}

	/**
	 * 更新一个回复
	 * 
	 * @param wxaccount
	 */
	public void updateCustomResp(CustomRespBean bean) {
		dao.update(bean);
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
	public void updateCustomRespByValue(String CustomRespBean,
			String[] columns, String[] values, String whereCause) {
		dao.updateByValue(CustomRespBean, columns, values, whereCause);
	}

	/**
	 * 依据id查询一个用户回复
	 * 
	 * @param id
	 * @return
	 */
	public CustomRespBean queryCustomResp(int id) {
		return dao.queryOne(id);
	}

	/**
	 * 依据条件查询CustomRespBean结果集
	 * 
	 * @param wxAccountId
	 *            :微信id
	 * @param type
	 *            :取值范围为：01：text 02：music 03：image 04：link 05: news 06: cmd 或者
	 *            ""：表示所有的
	 * @param page
	 *            : 为0 不分页 大于零分页查询
	 * @return
	 */
	public ArrayList<CustomRespBean> queryCustomResps(int wxAccountId,
			String type, int page, int pageSize) {
		String whereCause = "";
		ArrayList<CustomRespBean> list = new ArrayList<CustomRespBean>();
		if ("".equals(type)) {
			whereCause = " wxAccountId = " + wxAccountId;
		} else {
			whereCause = " where type = '" + type + "' and wxAccountId = "
					+ wxAccountId;
		}
		list = dao.queryCondition("CustomRespBean", whereCause, page, pageSize);
		return list;
	}

	public CustomRespDAO getDao() {
		return dao;
	}

	public void setDao(CustomRespDAO dao) {
		this.dao = dao;
	}

}
