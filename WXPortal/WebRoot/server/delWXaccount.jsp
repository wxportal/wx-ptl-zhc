<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.wxportal.dbservice.client.*"%>
<%@ page import="org.wxportal.dao.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	request.setCharacterEncoding("utf-8");
	String wxaccountid = (String) request.getParameter("wxaccountid");

	WXAccountDBService wxAccountDBService = new WXAccountDBService();

	boolean delStatus = wxAccountDBService.delWXAccount(new Integer(
			wxaccountid).intValue());

	if (delStatus) {
		request.getSession().setAttribute("delWXaccountStatus", "删除成功");

	} else {
		request.getSession().setAttribute("delWXaccountStatus", "删除失败");
	}

	response.sendRedirect("/WXPortal/myWXaccounts.jsp");
%>
