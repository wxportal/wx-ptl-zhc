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
					href="server/exit.jsp?curPage=functionManage" style="float: right;">安全退出&nbsp;&nbsp;</a>
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
	<table border="1" cellspacing="0" cellpadding="0" width="100%"
		bgcolor="#8976ff">
		<!-- 第二行表示菜单栏 -->
		<tr>
			<td width="35" class="STYLE7"><div align="center">
					<a href="index.jsp">首页</a>
				</div></td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="manage.jsp">管理</a>
				</div></td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="introduce.jsp">功能介绍</a>
				</div></td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="pay.jsp">资费</a>
				</div></td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="about.jsp">关于</a>
				</div></td>
			<td width="35" class="STYLE7"><div align="center">
					<a href="help.jsp">帮助</a>
				</div></td>
		</tr>
	</table>

	<table bgcolor="silver" width="100%">
		<!-- 第二行表示菜单栏 -->
		<tr>
			<td width="35" class="STYLE7"><div align="left">
					<a href="javascript:history.go(-1);">后退</a>&nbsp;<a
						href="javascript:history.go(1);">前进</a>&nbsp;<a
						href="javascript:window.parent.location.reload();">刷新</a>
				</div></td>
		</tr>
	</table>
	<%
		if (request.getSession().getAttribute("user") == null) {
	%>
	<form action="server/login.jsp" method="post">
		用户名：<input name="username" /> 密码：<input name="password"
			type="password" /> <input type="submit" value="登录" /><input
			type="hidden" name="curPage" value="functionManage" /> <input
			type="button"
			onclick="window.location='register.jsp?curPage=functionManage'"
			value="注册">
	</form>

	<%
		}
	%>

	<h2>功能管理</h2>
	<input type="button" onclick="window.location='manage.jsp'"
		value="返回公众号管理">
	<br />
	<br />
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
	<table cellpadding="10" cellspacing="0" border="1" width="100%">
		<tr>
			<td width="25%">aidanfd <br />微信号:lfdskafkd</td>
			<td width="25%">vip等级：1级</td>
			<td width="25%">购买时间：2012年9月10日</td>
			<td width="25%">到期时间：2013年9月10日</td>
		</tr>
		<tr>
			<td valign="top"><table width="100%" cellpadding="10">
					<!-- 基础设置 -->
					<tr>
						<td>&nbsp;<font color="blue">基础设置</font></td>
					</tr>
					<tr>
						<td><img src="images/menu_point.jpg" />&nbsp;<a
							href="functionManage.jsp"
							style="background-color: blue;color: white;">功能选择</a></td>
					</tr>
					<tr>
						<td><img src="images/menu_point.jpg" />&nbsp;<a
							href="watchedMsg.jsp">关注时回复</a></td>
					</tr>
					<tr>
						<td><img src="images/menu_point.jpg" />&nbsp;<a
							href="textResp.jsp">自定义文本回复</a></td>
					</tr>
					<tr>
						<td><img src="images/menu_point.jpg" />&nbsp;<a
							href="musicResp.jsp">自定义音乐回复</a></td>
					</tr>
					<tr>
						<td><img src="images/menu_point.jpg" />&nbsp;<a
							href="newsResp.jsp">自定义图文回复</a></td>
					</tr>
					<tr>
						<td><img src="images/menu_point.jpg" />&nbsp;<a
							href="unknownResp.jsp">不知道时答复</a></td>
					</tr>

					<!-- 3G站设置 -->
					<tr>
						<td>&nbsp;<font color="blue">3G站设置</font></td>
					</tr>

					<tr>
						<td><img src="images/menu_point.jpg" />&nbsp;<a
							href="3GDefine.jsp">3G站设置</a></td>
					</tr>
				</table></td>
			<td colspan="3" valign="top"><h3>已开发的功能</h3>
				<table width="100%" style="height: 100%;" cellpadding="10px"
					border="1" cellspacing="0">
					<tr>
						<td colspan="5"><font color="blue">VIP0可以使用的功能</font></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="fruit" value="apple">苹果</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
					</tr>

					<tr>
						<td colspan="5"><font color="blue">VIP1可以使用的功能</font></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="fruit" value="apple">苹果</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
					</tr>

					<tr>
						<td colspan="5"><font color="blue">VIP2可以使用的功能</font></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="fruit" value="apple">苹果</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
						<td><input type="checkbox" name="fruit" value="orange">桔子</input>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>
