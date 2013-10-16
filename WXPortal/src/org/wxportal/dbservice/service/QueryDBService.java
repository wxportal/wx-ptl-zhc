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
   //type:01：text 02：music 03：image 04：link 05:  news 06: cmd
	
	/**
	 * describe:依据用户请求的reqChar或者reqContent 和wxAccountId
	 *          查询用户定义的回复信息
	 * @param reqChar
	 * @param reqContent
	 * @param wxAccountId
	 * return 返回一个Map，map的key是依据请求的参数查询到的reqType，
	 *        map的value是查询到的用户自定义回复类容，如果不是新闻也不是""串
	 *        则value是一个Bean，是新闻则value是ArrayList<RespNewsBean>,
	 *        使用时依据reqType将Bean转成对应的类型.
	 *        否则 key="" value = "error";
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
