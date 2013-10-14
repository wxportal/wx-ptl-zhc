<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.wxportal.dbservice.client.*"%>
<%@ page import="org.wxportal.dao.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	request.setCharacterEncoding("utf-8");
	String name = (String) request.getParameter("name");
	String orgId = (String) request.getParameter("orgId");
	String wxNumber = (String) request.getParameter("wxNumber");
	String token = (String) request.getParameter("token");
	String area = (String) request.getParameter("area");
	String curPage = (String) request.getParameter("curPage");
	
	WXAccountDBService wxAccountDBService = new WXAccountDBService();
	
	WXAccountBean wxAccountBean = new WXAccountBean();
	
	wxAccountBean.setName(name);
	wxAccountBean.setOrgId(orgId);
	wxAccountBean.setWxNumber(wxNumber);
	wxAccountBean.setToken(token);
	wxAccountBean.setArea(area);
	
	// 此处改成，增加成功返回true,失败或异常，返回false,之后好做页面挑战判断
// 	wxAccountDBService.addWXAccount(wxAccountBean);
	request.getSession().setAttribute("addWXaccountStatus", "添加成功");
	response.sendRedirect("/WXPortal/addWXaccount.jsp");
	
	
%>
