<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.wxportal.dbservice.client.*"%>
<%@ page import="org.wxportal.dao.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	UserDBService userDBService = new UserDBService();
	UserBean userBean = new UserBean();

	request.setCharacterEncoding("utf-8");
	String nickName = (String) request.getParameter("nickname");

	String curPage = (String) request.getParameter("curPage");

	System.out.println(curPage);

	String password = (String) request.getParameter("password");
	String email = (String) request.getParameter("email");

	//首先判断用户是否存在
	if (userDBService.isUserExist(nickName)) {
		request.getSession().invalidate();
		request.getSession().setAttribute("registerStatus", "用户名已经存在");
		response.sendRedirect("/WXPortal/register.jsp");
	} else {
		userBean.setNickName(nickName);
		userBean.setPassWord(password);
		userBean.setEmail(email);

		int userId = userDBService.addUser(userBean);
		
		userBean.setId(userId);

		request.getSession().setAttribute("user", userBean);
		request.getSession().setAttribute("nickname", nickName);
		response.sendRedirect("/WXPortal/" + curPage + ".jsp");
	}
%>
