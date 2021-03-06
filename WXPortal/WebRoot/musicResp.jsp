<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.wxportal.dbservice.client.*"%>
<%@ page import="org.wxportal.dao.bean.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String wxaccountid = (String) request.getParameter("wxaccountid");
	if(wxaccountid == null){
	   wxaccountid = "0";//当用户未登录时，给定一个不存在的微信id
	}
    WXAccountDBService wxAccountDBService = new WXAccountDBService();
	WXAccountBean wxAccountBean = wxAccountDBService.queryWXAccount(new Integer(wxaccountid).intValue());
	RespDBService respDBService = new RespDBService();
	ArrayList<RespReturnBean> list = respDBService.getExistRespInfo(
			new Integer(wxaccountid).intValue(), "watched@unknown",
			"music", 0, 0);
			
	String message = "";
	if(request.getAttribute("message")!=null)		
	    message = request.getAttribute("message").toString();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>WXPortal</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script language="javascript">
		    //提交动作
		    function doSubmit(){
                var FormName = document.UploadForm;
                var reqContent = document.getElementById("reqContent").value;
                var title = document.getElementById("title").value;
                var linkUrl = document.getElementById("linkUrl").value;
                var description = document.getElementById("description").value;
                FormName.action = "<%=basePath%>UploadServlet?wxaccountid=<%=wxaccountid%>&type=music&reqContent="+reqContent+"&title="+title+"&linkUrl="+linkUrl+"&description="+description;
                FormName.submit();
		    }
		</script>
	</head>
	<body>
		<table border="1" cellspacing="0" cellpadding="0" width="100%">
			<!-- 第一行表示用户相关信息 -->
			<tr>
				<td height="20" valign="middle" width="50%">
					<span class="STYLE1">&nbsp;&nbsp; <%
 	if (request.getSession().getAttribute("user") != null) {
 		//如果已经登录
 %> 当前登录用户：<%=request.getSession().getAttribute("nickname")%> &nbsp;<a
						href="server/exit.jsp?curPage=musicResp" style="float: right;">安全退出&nbsp;&nbsp;</a>
						<%
							} else {
								//如果未登录
						%> 用户尚未登录 <%
							}
						%> </span><a href="#" style="float: right;">设为首页&nbsp;&nbsp;</a>
					<a href="#" style="float: right;">收藏本站&nbsp;&nbsp;</a>
				</td>

			</tr>
		</table>
		<table border="1" cellspacing="0" cellpadding="0" width="100%"
			bgcolor="#8976ff">
			<!-- 第二行表示菜单栏 -->
			<tr>
				<td width="35" class="STYLE7">
					<div align="center">
						<a href="index.jsp">首页</a>
					</div>
				</td>
				<td width="35" class="STYLE7">
					<div align="center">
						<a href="manage.jsp">管理</a>
					</div>
				</td>
				<td width="35" class="STYLE7">
					<div align="center">
						<a href="introduce.jsp">功能介绍</a>
					</div>
				</td>
				<td width="35" class="STYLE7">
					<div align="center">
						<a href="pay.jsp">资费</a>
					</div>
				</td>
				<td width="35" class="STYLE7">
					<div align="center">
						<a href="about.jsp">关于</a>
					</div>
				</td>
				<td width="35" class="STYLE7">
					<div align="center">
						<a href="help.jsp">帮助</a>
					</div>
				</td>
			</tr>
		</table>

		<table bgcolor="silver" width="100%">
			<!-- 第二行表示菜单栏 -->
			<tr>
				<td width="35" class="STYLE7">
					<div align="left">
						<a href="javascript:history.go(-1);">后退</a>&nbsp;
						<a href="javascript:history.go(1);">前进</a>&nbsp;
						<a href="javascript:window.parent.location.reload();">刷新</a>
					</div>
				</td>
			</tr>
		</table>
		<%
			if (request.getSession().getAttribute("user") == null) {
		%>
		<form action="server/login.jsp" method="post">
			用户名：
			<input name="username" />
			密码：
			<input name="password" type="password" />
			<input type="submit" value="登录" />
			<input type="hidden" name="curPage" value="newsResp" />
			<input type="button"
				onclick="window.location='register.jsp?curPage=newsResp'" value="注册"/>
		</form>

		<%
			}
		%>

		<h2>
			功能管理
		</h2>
		<input type="button" onclick="window.location='myWXaccounts.jsp'"
			value="返回公众号管理"/>
		<br />
		<br />

		<%
			if (request.getSession().getAttribute("user") == null) {
		%>
		<table border="1" cellpadding="10" cellspacing="0" width="100%">
			<tr>
				<td>
					您还尚未登录，请先登录！
				</td>
			</tr>
		</table>
		<%
			} else {
		%>
		<table cellpadding="10" cellspacing="0" border="1" width="100%">
			<tr>
				<td width="25%">
					微信名：<%=wxAccountBean.getName()%>
				</td>
				<td width="25%">
					微信号：<%=wxAccountBean.getWxNumber()%></td>
				<td width="25%">
					原始id:<%=wxAccountBean.getOrgId()%></td>
				<td width="25%">
					token:<%=wxAccountBean.getToken()%></td>
			</tr>
			<tr>
				<td width="20%" valign="top">
					<table width="100%" cellpadding="10">
						<!-- 基础设置 -->
						<tr>
							<td>
								&nbsp;
								<font color="blue">基础设置</font>
							</td>
						</tr>
						<tr>
							<td>
								<img src="images/menu_point.jpg" />
								&nbsp;
								<a href="functionManage.jsp?wxaccountid=<%=wxaccountid%>">功能选择</a>
							</td>
						</tr>
						<tr>
							<td>
								<img src="images/menu_point.jpg" />
								&nbsp;
								<a href="watchedMsg.jsp?wxaccountid=<%=wxaccountid%>">关注时回复</a>
							</td>
						</tr>
						<tr>
							<td>
								<img src="images/menu_point.jpg" />
								&nbsp;
								<a href="textResp.jsp?wxaccountid=<%=wxaccountid%>">自定义文本回复</a>
							</td>
						</tr>
						<tr>
							<td>
								<img src="images/menu_point.jpg" />
								&nbsp;
								<a href="musicResp.jsp?wxaccountid=<%=wxaccountid%>">自定义音乐回复</a>
							</td>
						</tr>
						<tr>
							<td>
								<img src="images/menu_point.jpg" />
								&nbsp;
								<a href="newsResp.jsp?wxaccountid=<%=wxaccountid%>"
									style="background-color: blue; color: white;">自定义图文回复</a>
							</td>
						</tr>
						<tr>
							<td>
								<img src="images/menu_point.jpg" />
								&nbsp;
								<a href="unknownResp.jsp?wxaccountid=<%=wxaccountid%>">不知道时答复</a>
							</td>
						</tr>

						<!-- 3G站设置 -->
						<tr>
							<td>
								&nbsp;
								<font color="blue">3G站设置</font>
							</td>
						</tr>

						<tr>
							<td>
								<img src="images/menu_point.jpg" />
								&nbsp;
								<a href="3GDefine.jsp?wxaccountid=<%=wxaccountid%>">3G站设置</a>
							</td>
						</tr>
					</table>
				</td>
				<td colspan="3" valign="top">
					<h3>
						自定义音乐回复
					</h3>
					<font color="red"><%=message %></font>
					<form name="UploadForm" enctype="multipart/form-data" method="post">
						<table width="100%" style="height: 100%;" cellpadding="10px"
							border="1" cellspacing="0">
							<tr>
								<td>
									关键字
								</td>
								<td>
									<input type="text" name="reqContent" id="reqContent" />
								</td>
							</tr>
							<tr>
								<td>
									音乐标题
								</td>
								<td>
									<input type="text" name="title" id="title" />
								</td>
							</tr>
							<tr>
								<td>
									音乐描述
								</td>
								<td>
									<input type="text" name="description" id="description" />
								</td>
							</tr>
							<tr>
								<td>
									音乐链接
								</td>
								<td>
									<input type="text" name="linkUrl" id="linkUrl" />
								</td>
							</tr>
							<tr>
								<td>
									上传地址
								</td>
								<td>
									<input type="file" name="File1" />
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="button" value="保存" onclick="doSubmit();"/>
								</td>
							</tr>
						</table>
					</form>
					<h3>
						已有配置
					</h3>
					<table width="100%" style="height: 100%; text-align: center;"
						cellpadding="10px" border="1" cellspacing="0">
						<tr>
							<td style="background-color: silver">
								关键字
							</td>
							<td style="background-color: silver">
								标题
							</td>
							<td style="background-color: silver">
								音乐描述
							</td>
							<td style="background-color: silver">
								链接
							</td>
							<td style="background-color: silver">
								音乐地址
							</td>
						</tr>
						<%
							for (RespReturnBean bean : list) {
						%>
						<tr>
							<td><%=bean.getReqContent()%></td>
							<td><%=bean.getTitle() %></td>
							<td><%=bean.getDescription() %></td>
							<td><%=bean.getLinkUrl() %></td>
							<td><%=bean.getRealUrl() %></td>
						</tr>
						<%
							}
						%>

					</table>
				</td>
			</tr>
		</table>
		<%
			}
		%>
	</body>
</html>
