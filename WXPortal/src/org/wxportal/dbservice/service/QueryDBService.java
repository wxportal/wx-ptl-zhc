package org.wxportal.dbservice.service;

import java.util.ArrayList;
import java.util.List;

import org.wxportal.dao.RespFunctionDAO;
import org.wxportal.dao.RespImageDAO;
import org.wxportal.dao.RespLinkDAO;
import org.wxportal.dao.RespMusicDAO;
import org.wxportal.dao.RespNewsDAO;
import org.wxportal.dao.RespTextDAO;

/**
 * 依据请求参数查询用户定义的回复信息
 * @author HanWei 2013/10/12
 * 
 *
 */
public class QueryDBService {
	
	/**
	 * describe:依据用户请求的reqChar或者reqContent 和wxAccountId
	 *          查询用户定义的回复信息
	 * @param reqChar
	 * @param reqContent
	 * @param wxAccountId
	 * return 返回结果是一个List结果集，list[0]是标识位“true”or"false"，true表示查询到了结果，false表示未查询到结果。
	 *        list[1]是返回的结果的类型：Text、Music、Image、Link、News、Function
	 *        list[2]及以后全部是用户自定义回复的内容
	 *
	 */
     
	public List queryInfo(String reqChar,String reqContent,int wxAccountId){
		String s = StringType.getType(reqChar, reqContent, wxAccountId);
		String sTyep = "";
		String reqKey = "";
		if(s.contains("@")){
			sTyep = s.split("@")[0];
			reqKey = s.split("@")[1];
		}
		return this.query(wxAccountId, sTyep, reqKey);
	}
	/**
	 * 依据请求参数查询用户自定义的非新闻回复
	 * @param reqChar
	 * @param reqContent
	 * @param wxAccountId
	 * @return
	 */
	private List query(int wxAccountId,String type,String reqKey){
		String sFlag = "false";
		String sType = "";
		List list = new ArrayList<Object>();
		if("text".equals(type)){
			RespTextDAO dao = new RespTextDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			list  = dao.queryByCondition(whereCause, 0, 0);
			if(list.size()>0){
				sFlag = "true";
				sType = "Text";
			}
			return this.toList(list, type, sFlag);
		}
		if("music".equals(type)){
			RespMusicDAO dao = new RespMusicDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			list  = dao.queryByCondition(whereCause, 0, 0);
			if(list.size()>0){
				sFlag = "true";
				sType = "Music";
			}
			return this.toList(list, type, sFlag);
		}
		if("image".equals(type)){
			RespImageDAO dao = new RespImageDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			list  = dao.queryByCondition(whereCause, 0, 0);
			if(list.size()>0){
				sFlag = "true";
				sType = "Image";
			}
			return this.toList(list, type, sFlag);
		}
		if("link".equals(type)){
			RespLinkDAO dao = new RespLinkDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			list  = dao.queryByCondition(whereCause, 0, 0);
			if(list.size()>0){
				sFlag = "true";
				sType = "Link";
			}
			return this.toList(list, type, sFlag);
		}
		if("news".equals(type)){
			RespNewsDAO dao = new RespNewsDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			list = dao.queryByCondition(whereCause, 0, 0);
			if(list.size()>0){
				sFlag = "true";
				sType = "News";
			}
			return this.toList(list, type, sFlag);
		}
		if("function".equals(type)){
			RespFunctionDAO dao = new RespFunctionDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			list  = dao.queryByCondition(whereCause, 0, 0);
			if(list.size()>0){
				sFlag = "true";
				sType = "Function";
			}
			return this.toList(list, sType, sFlag);
		}
 		return this.toList(list, sType, sFlag);
	}
	
   
	/**
	 * 拼接成返回的结果list
	 * @param list
	 * @param sType
	 * @param sFlag
	 * @return
	 */
	private List toList(List list,String sType,String sFlag){
		List result =  new ArrayList<Object>();
		result.add(sFlag);
		result.add(sType);
		if(list.size()>0){
			for(Object obj:list){
				result.add(obj);
			}
		}
		return result;
		
	}
	
}
