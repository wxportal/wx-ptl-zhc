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
	String creditCard = (String) request.getParameter("creditCard");
	String telephone = (String) request.getParameter("telephone");
	String addr = (String) request.getParameter("addr");

	UserDBService userDBService = new UserDBService();

	UserBean userBean = userDBService
			.getUserInfoByNickName((String) request.getSession()
					.getAttribute("nickname"));

	if (userBean != null) {
		userBean.setName(name);
		userBean.setCreditCard(creditCard);
		userBean.setTelphone(telephone);
		userBean.setAddr(addr);

		userDBService.updateUser(userBean);
		
		response.sendRedirect("/WXPortal/personInfo.jsp");
	}
%>
