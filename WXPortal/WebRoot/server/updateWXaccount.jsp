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
	String wxaccountid = (String) request.getParameter("wxaccountid");
	
	String curPage = (String) request.getParameter("curPage");

	WXAccountDBService wxAccountDBService = new WXAccountDBService();

	WXAccountBean wxAccountBean = new WXAccountBean();

	UserBean user = (UserBean) request.getSession()
			.getAttribute("user");

	wxAccountBean.setId(new Integer(wxaccountid).intValue());
	wxAccountBean.setName(name);
	wxAccountBean.setOrgId(orgId);
	wxAccountBean.setWxNumber(wxNumber);
	wxAccountBean.setToken(token);
	wxAccountBean.setArea(area);
	wxAccountBean.setUser(user);

	wxAccountDBService.updateWXAccount(wxAccountBean);
	request.getSession().setAttribute("delWXaccountStatus", "更新成功");
	response.sendRedirect("/WXPortal/myWXaccounts.jsp");
	// 	if (wxAccountDBService.isWXAccountExist("name", name)
	// 			|| wxAccountDBService.isWXAccountExist("orgId", orgId)
	// 			|| wxAccountDBService
	// 					.isWXAccountExist("wxNumber", wxNumber)
	// 			|| wxAccountDBService.isWXAccountExist("token", token)) {

	// 		request.getSession().setAttribute("addWXaccountStatus",
	// 				"添加失败，微信帐号名或原始id或微信号或token有重复");
	// 		response.sendRedirect("/WXPortal/addWXaccount.jsp");
	// 	} else {
	// 		if (wxAccountDBService.addWXAccount(wxAccountBean) > 0) {
	// 			request.getSession().setAttribute("addWXaccountStatus",
	// 					"添加成功");
	// 			response.sendRedirect("/WXPortal/addWXaccount.jsp");
	// 		} else {
	// 			request.getSession().setAttribute("addWXaccountStatus",
	// 					"添加失败成功");
	// 		}
	// 	}
%>
