<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
						if (request.getSession().getAttribute("user") != null) {
							//如果已经登录
					%> 当前登录用户：<%=request.getSession().getAttribute("nickname")%> &nbsp;<a
					href="server/exit.jsp?curPage=manage" style="float: right;">安全退出&nbsp;&nbsp;</a>
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
		if (request.getSession().getAttribute("user") == null) {
	%>
	<form action="server/login.jsp" method="post">
		用户名：<input name="username" /> 密码：<input name="password"
			type="password" /> <input type="submit" value="登录" /> <input
			type="hidden" name="curPage" value="manage" /><input type="button"
			onclick="window.location='register.jsp?curPage=manage'" value="注册">
	</form>

	<%
		}
	%>

	<h2>公众帐号管理</h2>
	<%
		if (request.getSession().getAttribute("user") == null) {
	%>
	<table border="1" cellpadding="10" cellspacing="0" width="100%">
		<tr>
			<td>您还尚未登录，请先登录！</td>
		</tr>
	</table>
	<%
		} else {
			response.sendRedirect("/WXPortal/personInfo.jsp");
		}
	%>

</body>
</html>
