<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.wxportal.dbservice.client.*"%>
<%@ page import="org.wxportal.dao.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String nickName = (String) request.getSession().getAttribute(
			"nickname");

	UserDBService userDBService = new UserDBService();
	UserBean userInfo = null;
	if (nickName != null) {
		userInfo = userDBService.getUserInfoByNickName(nickName);
	}
	// 	userInfo.setName("sss");
	// 	UserBean userInfo = UserDBService.getUserInfo(nickName);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WXPortal</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>
<body>
	<table border="1" cellspacing="0" cellpadding="0" width="100%">
		<!-- 第一行表示用户相关信息 -->
		<tr>
			<td height="20" valign="middle" width="50%"><span class="STYLE1">&nbsp;&nbsp;
					<%
						if (request.getSession().getAttribute("isLogin") != null
								&& request.getSession().getAttribute("isLogin")
										.equals("true")) {
							//如果已经登录
					%> 当前登录用户：<%=request.getSession().getAttribute("nickname")%> &nbsp;<a
					href="server/exit.jsp?curPage=personInfo" style="float: right;">安全退出&nbsp;&nbsp;</a>
					<%
						} else {
							//如果未登录
					%> 用户尚未登录 <%
						}
					%> </span><a href="#" style="float: right;">设为首页&nbsp;&nbsp;</a> <a
				href="#" style="float: right;">收藏本站&nbsp;&nbsp;</a></td>

		</tr>
	</table>
	<table border="1" cellspacing="0" cellpadding="0" width="100%"
		bgcolor="#8976ff">
		<!-- 第二行表示菜单栏 -->
		<tr>
			<td width="35" class="STYLE7"><div align="center">
					<a href="index.jsp">首页</a>
				</div>
			</td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="manage.jsp">管理</a>
				</div>
			</td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="introduce.jsp">功能介绍</a>
				</div>
			</td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="pay.jsp">资费</a>
				</div>
			</td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="about.jsp">关于</a>
				</div>
			</td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="help.jsp">帮助</a>
				</div>
			</td>
		</tr>
	</table>

	<table bgcolor="silver" width="100%">
		<!-- 第二行表示菜单栏 -->
		<tr>
			<td width="35" class="STYLE7"><div align="left">
					<a href="javascript:history.go(-1);">后退</a>&nbsp;<a
						href="javascript:history.go(1);">前进</a>&nbsp;<a
						href="javascript:window.parent.location.reload();">刷新</a>
				</div>
			</td>
		</tr>
	</table>
	<%
		if (request.getSession().getAttribute("isLogin") == null) {
	%>
	<form action="server/login.jsp" method="post">
		用户名：<input name="username" /> 密码：<input name="password"
			type="password" /> <input type="submit" value="登录" /> <input
			type="hidden" name="curPage" value="personInfo" /><input
			type="button" onclick="window.location='register.jsp?curPage=personInfo'" value="注册">
	</form>

	<%
		}
	%>

	<h2>公众帐号管理</h2>

	<%
		if (request.getSession().getAttribute("isLogin") == null) {
	%>
	<table border="1" cellpadding="10" cellspacing="0" width="100%">
		<tr>
			<td>您还尚未登录，请先登录！</td>
		</tr>
	</table>
	<%
		} else {
	%>
	<form action="server/fillUserInfo.jsp">

		<table border="1" cellpadding="10" cellspacing="0" width="100%">
			<tr>
				<td valign="top"><table width="100%" cellpadding="10">
						<tr>
							<td valign="top"><img src="images/menu_point.jpg" />&nbsp;<a
								href="personInfo.jsp"
								style="background-color: blue;color: white;">个人信息</a></td>
						</tr>
						<tr>
							<td><img src="images/menu_point.jpg" />&nbsp;<a
								href="myWXaccounts.jsp">我的公众帐号</a></td>
						</tr>
						<tr>
							<td><img src="images/menu_point.jpg" />&nbsp;<a
								href="addWXaccount.jsp" target="wxaccountContent">添加公众帐号</a></td>
						</tr>
					</table>
				</td>
				<td>
					<%
						if (userInfo == null || userInfo.getName() == null
									|| userInfo.getName().trim().equals("")) {
					%>
					<h3>请如实填写您的个人信息，一旦填写，无法修改！</h3> <%
 	}else{
 %>
 	<h3>如果您有信息填错，请联系系统管理员</h3>
 <%} %>
					<table width="100%" style="height: 100%;" cellpadding="10px"
						border="1" cellspacing="0">
						<%
							if (userInfo == null || userInfo.getName() == null
										|| userInfo.getName().trim().equals("")) {
						%>
						<tr>
							<td width="15%">*真实姓名</td>
							<td><input name="name" />
							</td>
							<td>请务必填写您的真实姓名，</td>
						</tr>

						<tr>
							<td width="15%">*身份证</td>
							<td><input name="creditCard" />
							</td>
							<td>请务必填写您的真实身份证信息</td>
						</tr>
						<tr>
							<td>*手机号</td>
							<td><input name="telephone" />
							</td>
							<td>必须正确的手机号,我们系统会自动监测你的vip1以上帐号，如果到期会自动发短信通知!</td>
						</tr>
						<tr>
							<td>*地址</td>
							<td><input name="addr" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td colspan="3" align="center"><input type="submit"
								value="提交" /></td>
						</tr>

						<%
							} else {
							
						%>
						
						<tr>
							<td width="15%">真实姓名</td>
							<td><%=userInfo.getName() %></td>
						</tr>

						<tr>
							<td width="15%">身份证</td>
							<td><%=userInfo.getCreditCard() %></td>
						</tr>
						<tr>
							<td>手机号</td>
							<td><%=userInfo.getTelphone() %></td>
						</tr>
						<tr>
							<td>地址</td>
							<td><%=userInfo.getAddr() %></td>
						</tr>
						<%
							}
						%>
					</table></td>
			</tr>
		</table>
	</form>

	<%
		}
	%>
</body>
</html>
