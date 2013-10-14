<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.wxportal.dbservice.client.*"%>
<%@ page import="org.wxportal.dao.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	request.setCharacterEncoding("utf-8");
	String username = (String) request.getParameter("username");
	String password = (String) request.getParameter("password");

	String curPage = (String) request.getParameter("curPage");

	UserDBService userDBService = new UserDBService();
	if (userDBService.login(username, password)) {
		request.getSession().setAttribute("isLogin", "true");
		request.getSession().setAttribute("nickname", username);
		response.sendRedirect("/WXPortal/" + curPage + ".jsp");
	} else {
		response.sendRedirect("/WXPortal/failure.jsp");
	}
%>
