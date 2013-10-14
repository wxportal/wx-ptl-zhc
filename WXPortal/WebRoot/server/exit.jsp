<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String curPage = request.getParameter("curPage");
	request.getSession().invalidate();
	response.sendRedirect("/WXPortal/" + curPage + ".jsp");
%>
