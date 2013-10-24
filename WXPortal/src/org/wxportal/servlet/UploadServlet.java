package org.wxportal.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wxportal.dao.bean.CustomRespBean;
import org.wxportal.dao.bean.RespMusicBean;
import org.wxportal.dao.bean.RespNewsBean;
import org.wxportal.dbservice.client.Md5Method;
import org.wxportal.dbservice.client.RespDBService;
import org.wxportal.dbservice.client.WXAccountDBService;

public class UploadServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "";
		String type = request.getParameter("type");
		String strReturn = this.upload(request, type);
		String strReturns[] = strReturn.split("@");
		if ("false".endsWith(strReturns[0])) {
			message = strReturns[1];
			request.setAttribute("message", message);
			request.setAttribute("wxaccountid", request
					.getAttribute("wxaccountid"));
			if ("news".equals(type)) {
				request.getRequestDispatcher("/newsResp.jsp").forward(request,
						response);
			}
			if ("music".equals(type)) {
				request.getRequestDispatcher("/musicResp.jsp").forward(request,
						response);
			}

		} else {
			request.setAttribute("wxaccountid", request
					.getAttribute("wxaccountid"));
			String fileName = strReturns[1];
			String url = "http://cooosuper.oicp.net/upload/" + type + "/"
					+ fileName;// 依据路径拼接成为访问PIC的路径

			// 接受参数
			String reqContent = request.getParameter("reqContent");
			String title = request.getParameter("title");
			String linkUrl = request.getParameter("linkUrl");
			String description = request.getParameter("description");

			CustomRespBean customRespBean = new CustomRespBean();// 定义customerRespBean

			// 获取wxAccountBean的查询方法
			WXAccountDBService wxAccountDBService = new WXAccountDBService();

			// 设置存储属性
			customRespBean.setReqChar("");
			customRespBean.setReqContent(reqContent);
			customRespBean.setReqKey(Md5Method.MD5(reqContent));
			customRespBean.setRespType(type);
			customRespBean.setWxAccount(wxAccountDBService
					.queryWXAccount(Integer.valueOf(request
							.getParameter("wxaccountid"))));
			
			if ("news".equals(type)) {//处理图文信息存储到数据库
				RespNewsBean respNewsBean = new RespNewsBean();// 定义RespNewsBean
				respNewsBean.setTitle(title);
				respNewsBean.setDescription(description);
				respNewsBean.setLinkUrl(linkUrl);
				respNewsBean.setReqKey(Md5Method.MD5(reqContent));
				respNewsBean.setPicUrl(url);
				respNewsBean.setWxAccountId(Integer.valueOf(request
						.getParameter("wxaccountid")));

				RespDBService respDBService = new RespDBService();// 存储用户定义回复的方法
				int i = respDBService.add(customRespBean, respNewsBean, "news");
				if (i != -1) {
					request.setAttribute("message", "文件上传成功!");
					request.getRequestDispatcher("/newsResp.jsp").forward(
							request, response);
				} else {
					this.delFile(fileName);// 删除上传上去的文件
					request.setAttribute("message", "文件上传失败!");
					request.getRequestDispatcher("/newsResp.jsp").forward(
							request, response);
				}
			}
			
			if("music".equals(type)){//处理音乐信息存储数据库
				RespMusicBean respMusicBean = new RespMusicBean();// 定义RespMusiBean
				respMusicBean.setTitle(title);
				respMusicBean.setDescription(description);
				respMusicBean.setLinkUrl(linkUrl);
				respMusicBean.setReqKey(Md5Method.MD5(reqContent));
				respMusicBean.setRealUrl(url);
				respMusicBean.setWxAccountId(Integer.valueOf(request
						.getParameter("wxaccountid")));

				RespDBService respDBService = new RespDBService();// 存储用户定义回复的方法
				int i = respDBService.add(customRespBean, respMusicBean, "music");
				if (i != -1) {
					request.setAttribute("message", "音乐上传成功!");
					request.getRequestDispatcher("/musicResp.jsp").forward(
							request, response);
				} else {
					this.delFile(fileName);// 删除上传上去的文件
					request.setAttribute("message", "音乐上传失败!");
					request.getRequestDispatcher("/musicResp.jsp").forward(
							request, response);
				}
				
			}
		}
	}

	// 文件上传
	private String upload(HttpServletRequest request, String type) {
		String strReturn = "";// 返回的字符串以@符号分割
		// 定义上载文件的最大字节
		int MAX_SIZE = 102400 * 102400;
		// 创建根路径的保存变量
		String rootPath;

		// 声明文件读入类
		DataInputStream in = null;
		FileOutputStream fileOut = null;
		// 取得客户端的网络地址
		String remoteAddr = request.getRemoteAddr();
		// 获得服务器的名字
		String serverName = request.getServerName();
		// 取得互联网程序的绝对地址
		String realPath = request.getRealPath(serverName);
		realPath = realPath.substring(0, realPath.lastIndexOf("\\"));
		// 创建文件的保存目录
		rootPath = realPath + "\\upload\\" + type + "\\";
		// 取得客户端上传的数据类型
		String contentType = request.getContentType();
		try {
			if (contentType.indexOf("multipart/form-data") >= 0) {
				// 读入上传的数据
				in = new DataInputStream(request.getInputStream());
				int formDataLength = request.getContentLength();
				if (formDataLength > MAX_SIZE) {
					strReturn = "false@上传的文件字节数不可以超过" + MAX_SIZE;
					return strReturn;
				}
				// 保存上传文件的数据
				byte dataBytes[] = new byte[formDataLength];
				int byteRead = 0;
				int totalBytesRead = 0;
				// 上传的数据保存在byte数组
				while (totalBytesRead < formDataLength) {
					byteRead = in.read(dataBytes, totalBytesRead,
							formDataLength);
					totalBytesRead += byteRead;
				}
				// 根据byte数组创建字符串
				String file = new String(dataBytes);
				// 取得上传的数据的文件名
				String saveFile = file
						.substring(file.indexOf("filename=\"") + 10);
				saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
				saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
						saveFile.indexOf("\""));
				int lastIndex = contentType.lastIndexOf("=");
				// 取得数据的分隔字符串
				String boundary = contentType.substring(lastIndex + 1,
						contentType.length());
				// 创建保存路径的文件名
				saveFile = new String(saveFile.getBytes(), "utf-8");
				String fileName = rootPath + saveFile;
				int pos;
				pos = file.indexOf("filename=\"");
				pos = file.indexOf("\n", pos) + 1;
				pos = file.indexOf("\n", pos) + 1;
				pos = file.indexOf("\n", pos) + 1;
				int boundaryLocation = file.indexOf(boundary, pos) - 4;
				// 取得文件数据的开始的位置
				int startPos = ((file.substring(0, pos)).getBytes()).length;
				// 取得文件数据的结束的位置
				int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
				// 检查上载文件是否存在
				File checkFile = new File(fileName);
				if (checkFile.exists()) {
					strReturn = "false@" + saveFile + "文件已经存在";
					return strReturn;
				}
				// 检查上载文件的目录是否存在
				File fileDir = new File(rootPath);
				if (!fileDir.exists()) {
					fileDir.mkdirs();
				}
				// 创建文件的写出类
				fileOut = new FileOutputStream(fileName);
				// 保存文件的数据
				fileOut.write(dataBytes, startPos, (endPos - startPos));
				fileOut.close();
				System.out.println("<P>" + saveFile + "文件成功上载.</p>");
				strReturn = "true@" + saveFile;
			} else {
				String content = request.getContentType();
				System.out.println("<p>上传的数据类型不是是multipart/form-data</p>");
				strReturn = "false@上传的数据类型不是是multipart/form-data";
				return strReturn;
			}
		} catch (Exception ex) {
			try {
				throw new ServletException(ex.getMessage());
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return strReturn;
	}

	/**
	 * 当文件信息保存数据库失败后，而文件已经上传到服务器时，则删除上传的文件
	 */
	private void delFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
