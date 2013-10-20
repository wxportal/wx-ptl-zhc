package org.wxportal.message.db;

import java.util.ArrayList;
import java.util.List;

public class DBAction {
	/**
	 * Common class to manager all request about DB.
	 * 
	 * @author:Dawei Zhang
	 * @date 2013-10-03
	 */

	/**
	 * Get the response message(type,content) through user name and content.
	 * 
	 * @param userName
	 * @param content
	 * @return
	 */
	public static List<Object> getRespTypeAndContent(String userName,
			String content) {
		// Need add search DB method
		List<Object> list = new ArrayList<Object>();
		list.add("false");
		return list;
	}
}
