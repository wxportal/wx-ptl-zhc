<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.wxportal.dbservice.client.*"%>
<%@ page import="org.wxportal.dao.bean.*"%>
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
					href="server/exit.jsp?curPage=addWXaccount" style="float: right;">安全退出&nbsp;&nbsp;</a>
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
			type="hidden" name="curPage" value="addWXaccount" /><input
			type="button"
			onclick="window.location='register.jsp?curPage=addWXaccount'"
			value="注册">
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
	%>

	<table border="1" cellpadding="10" cellspacing="0" width="100%">
		<tr>
			<td valign="top" width="20%"><table width="100%"
					cellpadding="10">
					<tr>
						<td valign="top"><img src="images/menu_point.jpg" />&nbsp;<a
							href="personInfo.jsp">个人信息</a></td>
					</tr>
					<tr>
						<td><img src="images/menu_point.jpg" />&nbsp;<a
							href="myWXaccounts.jsp">我的公众帐号</a>
						</td>
					</tr>
					<tr>
						<td><img src="images/menu_point.jpg" />&nbsp;<a
							href="addWXaccount.jsp"
							style="background-color: blue;color: white;">添加公众帐号</a></td>
					</tr>
				</table>
			</td>
			<td>
				<h3>添加公众帐号</h3> <%
 	if (request.getSession().getAttribute("addWXaccountStatus") != null) {
 %> <font color="red">添加用户成功</font> <%
 	request.getSession().setAttribute("addWXaccountStatus",
 					null);
 		}
 %>
				<form action="server/addWXaccount.jsp" method="post">
					<table width="100%" style="height: 100%;" cellpadding="10px"
						border="1" cellspacing="0">
						<tr>
							<td width="20%">*公众帐号名称</td>
							<td><input name="name" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td>*公众帐号原始id</td>
							<td><input name="orgId" />
							</td>
							<td>请认真填写，错了不能修改。比如：gh_31a785317770 [<a href="">不会就点我</a>]</td>
						</tr>
						<tr>
							<td>*微信号</td>
							<td><input name="wxNumber" />
							</td>
							<td>比如：Cooosuper</td>
						</tr>
						<!-- 						<tr> -->
						<!-- 							<td>*接口地址</td> -->
						<!-- 							<td><input /></td> -->
						<!-- 							<td>http://你自己域名/coreServlet?token=xxx</td> -->
						<!-- 						</tr> -->

						<tr>
							<td>*token</td>
							<td><input name="token" />
							</td>
							<td>此处token和中转接口以及腾讯平台必须一致，为保证你的资源不被他人盗用，可以自己将中转接口的token值改为当前你设定的值!</td>
						</tr>

						<tr>
							<td>*地区</td>
							<td><input name="area" />
							</td>
							<td>此处关联公交等本地化查询</td>
						</tr>
						<tr>
							<td colspan="3" align="center"><input type="submit"
								value="保存" /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>

	<%
		}
	%>
</body>
</html>
