<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String curPage = (String) request.getParameter("curPage");
	System.out.println("当前页面：" + curPage);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WXPortal</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		$("#nickname").blur(function() {
			// 用户名为空检验
			if ($("#nickname").val().replace(/^\s+|\s+$/g, '') == '') {
				$("#nicknametips").html("用户名不能为空");
				$("#nicknametips").css("color", "red");
			} else {
				$("#nicknametips").html("用户登录名");
				$("#nicknametips").css("color", "black");
			}
		});
	})
</script>
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
							System.out.print("用户名："
									+ request.getSession().getAttribute("nickname"));
							//如果已经登录
					%> 当前登录用户：<%=request.getSession().getAttribute("nickname")%> &nbsp;<a
					href="server/exit.jsp?curPage=index" style="float: right;">安全退出&nbsp;&nbsp;</a>
					<%
						} else {
							//如果未登录
					%> 用户尚未登录 <%
						}
					%> </span><a href="#" style="float: right;">设为首页&nbsp;&nbsp;</a> <a
				href="#" style="float: right;">收藏本站&nbsp;&nbsp;</a>
			</td>
		</tr>
	</table>
	</td>
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
			type="password" /> <input type="submit" value="登录" /><input
			type="hidden" name="curPage" value="register" /> <input
			type="button"
			onclick="window.location='register.jsp?curPage=register'" value="注册" />
	</form>

	<%
		}
	%>

	<h2>用户注册</h2>
	<font color="red" size="4">请如实填写对应信息，其中有些信息与微信帐号有关！切勿填写虚假信息！谢谢合作！</font>

	<%
		if (request.getSession().getAttribute("registerStatus") != null) {
	%>
	<br />
	<font color="red" size="4"><%=request.getSession().getAttribute("registerStatus")%></font>
	<%
		request.getSession().setAttribute("registerStatus", null);
		}
	%>
	<form action="server/register.jsp?curPage=<%=curPage %>" method="post">
		<table border="1" cellpadding="10" cellspacing="0" width="100%">
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="nickname" name="nickname" /></td>
				<td id="nicknametips">用户登录名</td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码：</td>
				<td><input name="password" /></td>
				<td>用户登录密码</td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input name="password" /></td>
				<td>密码确认</td>
			</tr>
			<tr>
				<td>邮&nbsp;&nbsp;箱：</td>
				<td><input name="email" />
				</td>
				<td>常用邮箱</td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="确定注册" /></td>
			</tr>
		</table>
	</form>


</body>
</html>
