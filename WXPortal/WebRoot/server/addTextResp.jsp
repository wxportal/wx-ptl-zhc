<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.wxportal.dbservice.client.*"%>
<%@ page import="org.wxportal.dao.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	request.setCharacterEncoding("utf-8");
	String watchedRespText = (String) request
			.getParameter("textRespText");
	String wxaccountid = (String) request.getParameter("wxaccountid");

	String reqChar = (String) request.getParameter("reqChar");
	String reqContent = (String) request.getParameter("reqContent");

	WXAccountDBService wxAccountDBService = new WXAccountDBService();

	RespDBService respDBService = new RespDBService();

	CustomRespBean customRespBean = new CustomRespBean();
	customRespBean.setReqChar(reqChar);
	customRespBean.setReqContent(reqContent);
	customRespBean.setRespType("text");
	customRespBean.setWxAccount(wxAccountDBService
			.queryWXAccount(new Integer(wxaccountid).intValue()));

	String reqKey = null;
	if (reqChar != null) {
		System.out.println(Md5Method.MD5(reqChar));
		reqKey = Md5Method.MD5(reqChar);
		customRespBean.setReqKey(reqKey);
	} else {
		reqKey = Md5Method.MD5(reqContent);
		customRespBean.setReqKey(reqKey);
	}

	RespTextBean respTextBean = new RespTextBean();

	respTextBean.setContent(watchedRespText);
	respTextBean.setReqKey(reqKey);
	respTextBean.setWxAccountId(new Integer(wxaccountid).intValue());
	int result = respDBService
			.add(customRespBean, respTextBean, "text");

	if (result != -1) {
		request.getSession()
				.setAttribute("addTextMsgStatus", "添加成功");
		response.sendRedirect("/WXPortal/textResp.jsp?wxaccountid="
				+ wxaccountid);
	} else {
		request.getSession()
				.setAttribute("addTextMsgStatus", "添加失败");
		response.sendRedirect("/WXPortal/textResp.jsp?wxaccountid="
				+ wxaccountid);
	}
%>
