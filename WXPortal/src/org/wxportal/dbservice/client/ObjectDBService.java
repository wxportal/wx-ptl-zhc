package org.wxportal.dbservice.client;

import java.util.List;

import org.wxportal.dao.DAOMethod;

/**
 * 自定义回复详细类型相关(infoType)，主要包括： text,music,image,link，news,function
 * 
 * @author HanWei 2013/10/09
 * 
 */
public class ObjectDBService {

	private DAOMethod dao = new DAOMethod();

	/**
	 * 
	 * @param object
	 * @param infoType
	 * @return
	 */
	public String add(Object object, String infoType) {
		int i = dao.getDAO(infoType).add(object);
		if (i > 0) {
			return i + "@" + infoType;
		}
		return "-1";
	}

	/**
	 * 依据id删除一个对象
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id, String infoType) {
		return dao.getDAO(infoType).delete(id);
	}

	/**
	 * 删除多条记录
	 * 
	 * @param ids
	 * @return
	 */
	public boolean deletes(int[] ids, String infoType) {
		boolean bFlag = true;
		for (int i = 0; i < ids.length; i++) {
			if (!delete(ids[i], infoType)) {
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
	 * @param object
	 * @param columns
	 * @param values
	 * @param infoType
	 * @return
	 */
	public boolean delByValues(Object object, String[] columns,
			String[] values, String infoType) {
		return dao.getDAO(infoType).delByValue(object, columns, values);
	}

	/**
	 * 更新一个对象
	 * 
	 * @param wxaccount
	 */
	public boolean update(Object object, String infoType) {
		return dao.getDAO(infoType).update(object);
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
	public boolean updateByValue(Object object, String[] columns, String[] values,
			String whereCause, String infoType) {
		return dao.getDAO(infoType).updateByValue(object, columns, values, whereCause);
	}

	/**
	 * 依据id查询一个用户回复
	 * 
	 * @param id
	 * @return
	 */
	public Object query(int id, String infoType) {
		return dao.getDAO(infoType).query(id);
	}

	/**
	 * 查询一个微信账号下所有的回复具体信息
	 * 
	 * @param wxAccountId
	 * @param infoType
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List querys(int wxAccountId, String infoType, int page, int pageSize) {
		return dao.getDAO(infoType).querys(wxAccountId, page, pageSize);
	}
}
