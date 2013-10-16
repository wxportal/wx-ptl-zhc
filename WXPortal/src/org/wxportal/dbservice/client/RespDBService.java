package org.wxportal.dbservice.client;

import java.util.ArrayList;
import java.util.List;

import org.wxportal.dao.bean.CustomRespBean;

/**
 * 处理用户自定义回复的方法
 * @author hanwei
 *
 */
public class RespDBService {
	
	private CustomRespDBService cService = new CustomRespDBService();
	
	private ObjectDBService oService = new ObjectDBService();

	/**
	 * 
	 * @param customResp
	 * @param respObject
	 * @param type
	 * @return i返回-1 新增失败 否则返回新增的CustomerRespBean的id
	 */
	public int add(CustomRespBean customResp,Object respObject,String type){
		int i = cService.addCustomResp(customResp);
		String s = oService.add(respObject, type);
		if("-1".equals(s)){
			return -1;
		}
		return i;
	}
	
	/**
	 * 查询用户已有配置
	 * @param wxAccountId
	 * @param specialTypes
	 *                    :特殊类型，如“关注时回复”，“不知道是回复”，多个类型请用'@'拼接成一个字符串
	 * @param type
	 * @param page
	 * @param pageSize
	 * @return：返回结果为List，
	 *         第一个元素为用户自定回复关键字的结果list
	 *         第二个元素为用户自定义回复的内容的结果list
	 *         
	 */
	public List getExistRespInfo(int wxAccountId,String specialTypes,String type,int page,int pageSize){
		List list = new ArrayList<Object>();
		List CustomRespList = cService.queryCustomResps(wxAccountId, type, page, pageSize);
		List ObjectList = oService.querys(wxAccountId, type, page, pageSize);
		list.add(CustomRespList);
		list.add(ObjectList);
		this.removeSprecialResp(list, specialTypes, type, wxAccountId, page, pageSize);
		return list;
	}
	
	/**
	 * 去除掉特殊回复
	 * @param list
	 * @param specialTypes
	 * @param type
	 * @param wxAccountId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	private List removeSprecialResp(List list,String specialTypes,String type,int wxAccountId,int page,int pageSize){
		String specialTypeArray[] = specialTypes.split("@");
		ArrayList<CustomRespBean> CustomRespList = (ArrayList<CustomRespBean>)list.get(0);
		for(CustomRespBean bean:CustomRespList){
			for(String specialType:specialTypeArray){
				if(specialType.equals(bean.getRespType())){
					CustomRespList.remove(bean);
					String reqKey = bean.getReqKey();
					String whereCause = " where reqKey = '"+reqKey+"' and wxAccountId = "+wxAccountId;
					List objectList =oService.queryByConditions(whereCause, type, page, pageSize);
					if(objectList != null && objectList.size() > 0){
						Object object = objectList.get(0);
						ArrayList<Object> ObjectList2 = (ArrayList<Object>)list.get(1);
						ObjectList2.remove(object);
					}
				}
			}
			
		}
		return list;
	}

	public CustomRespDBService getCService() {
		return cService;
	}

	public void setCService(CustomRespDBService service) {
		cService = service;
	}

	public ObjectDBService getOService() {
		return oService;
	}

	public void setOService(ObjectDBService service) {
		oService = service;
	}
	
}
