package org.wxportal.dbservice.client;

import java.util.ArrayList;

import org.wxportal.dao.FunctionsDAO;
import org.wxportal.dao.bean.FunctionsBean;

/**
 * 系统功能相关
 * 
 * @author HanWei 2013/10/12
 * 
 */
public class FunctionsDBService {

	private FunctionsDAO dao = new FunctionsDAO();

	/**
	 * 系统功能名字是否存在
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean isFunctionsExist(String name) {
		boolean bFlag = true;
		ArrayList<FunctionsBean> list = new ArrayList<FunctionsBean>();
		list = (ArrayList<FunctionsBean>) dao.query("FunctionsBean",
				new String[] { "name" }, new String[] { name }, 0, 0);
		if (list.size() > 0)
			bFlag = false;
		return bFlag;
	}

	/**
	 * add a FunctionsBean
	 * 
	 * @param bean
	 * @return
	 */
	public int addFuctions(FunctionsBean bean) {
		return dao.add(bean);
	}

	/**
	 * 依据id删除一个对象
	 * 
	 * @param id
	 * @return:True：成功 False：失败
	 */
	public boolean delOneFuns(int id) {
		return dao.delete(FunctionsBean.class, id);
	}

	/**
	 * 删除选中的对象
	 * 
	 * @param ids
	 * @return True：成功 False：失败
	 */
	public boolean delFuns(int[] ids) {
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
	 * 更新一个user对象
	 * 
	 * @param user
	 */
	public boolean updateFuns(FunctionsBean bean) {
		return dao.update(bean);
	}

	/**
	 * 依据id查询一个FunctionsBean
	 * 
	 * @param id
	 * @return
	 */
	public FunctionsBean queryOneFunctions(int id) {
		return dao.queryOne(id);
	}

	/**
	 * 查询父节点下所有的子功能
	 * 
	 * @param pFucntionsId
	 *            :为""是查询所有的功能信息
	 * @return
	 */
	public ArrayList<FunctionsBean> queryFunctions(String pFucntionsId) {
		if ("".equals(pFucntionsId)) {
			return dao.query("FunctionsBean", new String[] {}, new String[] {},
					0, 0);
		}
		return dao.query("FunctionsBean", new String[] { "pFunctionId" },
				new String[] { pFucntionsId }, 0, 0);
	}

	public FunctionsDAO getDAO() {
		return dao;
	}

	public void setDAO(FunctionsDAO dao) {
		this.dao = dao;
	}

}
