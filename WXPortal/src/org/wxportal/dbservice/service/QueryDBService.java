package org.wxportal.dbservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wxportal.dao.RespFunctionDAO;
import org.wxportal.dao.RespImageDAO;
import org.wxportal.dao.RespLinkDAO;
import org.wxportal.dao.RespMusicDAO;
import org.wxportal.dao.RespNewsDAO;
import org.wxportal.dao.RespTextDAO;
import org.wxportal.dao.bean.RespNewsBean;

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
	public Map query(String reqChar,String reqContent,int wxAccountId){
		String s = StringType.getType(reqChar, reqContent, wxAccountId);
		String type = s.split("@")[0];
		String reqKey = s.split("@")[1];
		if("05".equals(type)){
			return this.queryNews(wxAccountId, type, reqKey);
		}else{
			return this.queryInfo(wxAccountId, type, reqKey);
		}
	}
	/**
	 * 依据请求参数查询用户自定义的非新闻回复
	 * @param reqChar
	 * @param reqContent
	 * @param wxAccountId
	 * @return
	 */
	private HashMap<String,Object> queryInfo(int wxAccountId,String type,String reqKey){
		HashMap<String,Object> map = new HashMap<String,Object>();
		if("01".equals(type)){
			RespTextDAO dao = new RespTextDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			List list  = dao.queryByCondition("RespTextBean", whereCause, 0, 0);
			map.put(type, list.get(0));
			return map;
		}
		if("02".equals(type)){
			RespMusicDAO dao = new RespMusicDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			List list  = dao.queryByCondition("RespMusicBean", whereCause, 0, 0);
			map.put(type, list.get(0));
			return map;
		}
		if("03".equals(type)){
			RespImageDAO dao = new RespImageDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			List list  = dao.queryByCondition("RespImageBean", whereCause, 0, 0);
			map.put(type, list.get(0));
			return map;
		}
		if("04".equals(type)){
			RespLinkDAO dao = new RespLinkDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			List list  = dao.queryByCondition("RespLinkBean", whereCause, 0, 0);
			map.put(type, list.get(0));
			return map;
		}
		if("06".equals(type)){
			RespFunctionDAO dao = new RespFunctionDAO();
			String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
			List list  = dao.queryByCondition("RespFunctionBean", whereCause, 0, 0);
			map.put(type, list.get(0));
			return map;
		}
		map.put("", "error");
		return map;
	}
	
   
	/**
	 * 回复新闻相关查询
	 * @param wxAccountId
	 * @param type
	 * @param reqKey
	 * @return
	 */
	private HashMap<String,List> queryNews(int wxAccountId,String type,String reqKey){
		List list = new ArrayList<RespNewsBean>();
		HashMap<String,List> map = new HashMap<String,List>();
		RespNewsDAO dao = new RespNewsDAO();
		String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
		list = dao.queryByCondition("RespNewsBean", whereCause, 0, 0);
		map.put(type, list);
		return map;
	}
	
}
