package org.wxportal.dbservice.client;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.wxportal.dao.UserDAO;
import org.wxportal.dao.bean.UserBean;

/**
 * the services of user, including judging user exist,adding deleting updating
 * user's informations，login and so on
 * 
 * @author HanWei 2013/09/27
 * 
 */
public class UserDBService {

	private UserDAO userDAO = new UserDAO();

	/**
	 * judging the exist of user'nickName
	 * 
	 * @param nickName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean isUserExist(String nickName) {
		boolean bFlag = false;
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		list = (ArrayList<UserBean>) userDAO.queryUsers("UserBean",
				new String[] { "nickName" }, new String[] { nickName }, 0, 0);
		if (list.size() > 0)
			bFlag = true;
		return bFlag;
	}

	/**
	 * add a user
	 * 
	 * @param user
	 *            ：其属性‘密码’不需要加密的
	 * @return
	 */
	public int addUser(UserBean user) {
		// user.setPassWord(Md5Method.MD5(user.getPassWord()));// 密码md5加密
		return userDAO.addUser(user);
	}

	/**
	 * 依据id删除一个对象
	 * 
	 * @param id
	 * @return
	 */
	public boolean delUser(int id) {
		return userDAO.deleteUser(id);
	}

	/**
	 * 依据条件删除对象
	 * 
	 * @param UserBean
	 * @param columns
	 * @param values
	 * @return
	 */
	public boolean delUserByValues(String UserBean, String[] columns,
			String[] values) {
		return userDAO.delByValue(UserBean, columns, values);
	}

	/**
	 * 更新一个user对象
	 * 
	 * @param user
	 */
	public void updateUser(UserBean user) {
		userDAO.update(user);
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
	public void updateUserByValue(String UserBean, String[] columns,
			String[] values, String whereCause) {
		userDAO.updateByValue(UserBean, columns, values, whereCause);
	}

	/**
	 * 依据id查询一个user
	 * 
	 * @param id
	 * @return
	 */
	public UserBean queryUser(int id) {
		return userDAO.querUser(id);
	}

	public UserBean getUserInfoByNickName(String nickName) {
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		list = (ArrayList<UserBean>) userDAO.queryUsers("UserBean",
				new String[] { "nickName" }, new String[] { nickName }, 0, 0);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 依据条件查询user结果集
	 * 
	 * @param UserBean
	 * @param columns
	 * @param values
	 * @return
	 */
	public ArrayList<UserBean> queryUsers(String UserBean, String[] columns,
			String[] values, int page, int pageSize) {
		return userDAO.queryUsers(UserBean, columns, values, page, pageSize);
	}

	/**
	 * 判断用户名密码是否正确
	 * 
	 * @param nickName
	 * @param passWord
	 * @return
	 */
	public UserBean login(String nickName, String passWord) {
		// String psw = Md5Method.MD5(passWord);
		ArrayList<UserBean> list = queryUsers("UserBean", new String[] {
				"nickName", "passWord" }, new String[] { nickName, passWord },
				0, 0);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 用户注销
	 * 
	 * @param request
	 *            注意：User为session中存在的当前用户的对象
	 */
	public boolean exit(HttpServletRequest request) {
		boolean bFlag = false;
		request.getSession().invalidate();
		if (request.getSession().getAttribute("User") == null) {
			bFlag = true;
		}
		return bFlag;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
