package org.wxportal.dbservice.client;

import java.util.ArrayList;
import java.util.List;

import org.wxportal.dao.bean.CustomRespBean;
import org.wxportal.dao.bean.RespFunctionBean;
import org.wxportal.dao.bean.RespImageBean;
import org.wxportal.dao.bean.RespLinkBean;
import org.wxportal.dao.bean.RespMusicBean;
import org.wxportal.dao.bean.RespNewsBean;
import org.wxportal.dao.bean.RespReturnBean;
import org.wxportal.dao.bean.RespTextBean;

/**
 * 处理用户自定义回复的方法
 * 
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
	public int add(CustomRespBean customResp, Object respObject, String type) {
		int i = cService.addCustomResp(customResp);
		String s = oService.add(respObject, type);
		if ("-1".equals(s)) {
			return -1;
		}
		return i;
	}

	/**
	 * 查询用户已有配置
	 * 
	 * @param wxAccountId
	 * @param specialTypes
	 *            :特殊类型，如“关注时回复”，“不知道是回复”，多个类型请用'@'拼接成一个字符串
	 * @param type
	 * @param page
	 * @param pageSize
	 * @return：返回结果为List
	 * 
	 */
	public ArrayList<RespReturnBean> getExistRespInfo(int wxAccountId, String specialTypes,
			String type, int page, int pageSize) {
		List CustomRespList = cService.queryCustomResps(specialTypes,
				wxAccountId, type, page, pageSize);
		List SpecialList = this.querySpecial(specialTypes, wxAccountId);
		List ObjectList = oService.querys(wxAccountId, type, page, pageSize);
		ObjectList = this.removeSprecialResp(ObjectList, SpecialList);
		ArrayList<RespReturnBean>  returnList = new ArrayList<RespReturnBean>();
		returnList = this.produceRespReturnBeans(type, CustomRespList, ObjectList);
		return returnList;
	}

	/**
	 * 查询特殊回复
	 * 
	 * @param wxAccountId
	 * @param specialType
	 * @return
	 */
	public ArrayList<RespReturnBean>  getSpecialResp(int wxAccountId, String specialType) {
		List<CustomRespBean> list1 = this
				.querySpecial(specialType, wxAccountId);
		if (list1.size() > 0) {
			String type = "text";// 特殊回复的类型暂定为文本
			String whereCause = " where 1=1 and (";
			for (CustomRespBean bean : list1) {
				whereCause += " reqKey = '" + bean.getReqKey() + "' or ";
			}
			whereCause = whereCause.substring(0, whereCause.lastIndexOf("or"))+" ) ";
			whereCause += " and wxAccountid = " + wxAccountId;
			List list2 = oService.queryByConditions(whereCause, type, 0, 0);
			ArrayList<RespReturnBean>  returnList = new ArrayList<RespReturnBean>();
			returnList = this.produceRespReturnBeans(type, list1, list2);
			return returnList;
		}
		return null;
	}

	/**
	 * 查询用户自定义回复特殊回复
	 * 
	 * @param specialTypes
	 * @param wxAccountId
	 * @return
	 */
	private List<CustomRespBean> querySpecial(String specialTypes,
			int wxAccountId) {
		String[] specalTypeArray = specialTypes.split("@");
		String whereCause = " where 1=1";
		for (String s : specalTypeArray) {
			String s1 = "%" + s;
			whereCause += " and resptype like '" + s1 + "' ";
		}
		whereCause += " and wxAccountId = " + wxAccountId;
		List<CustomRespBean> SpecialList = cService
				.querySpecialResp(whereCause);
		return SpecialList;
	}

	/**
	 * 去除掉特殊回复
	 * 
	 * @param list
	 * @param specialTypes
	 * @param type
	 * @param wxAccountId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	private List removeSprecialResp(List ObjectList, List SpecialList) {
		for (Object bean : SpecialList) {
			ObjectList.remove(bean);
		}
		return ObjectList;
	}

	private ArrayList<RespReturnBean> produceRespReturnBeans(String type,
			List CustomRespList, List ObjectList) {
		ArrayList<RespReturnBean> list = new ArrayList<RespReturnBean>();
		if("text".equals(type)){
			for(Object object:ObjectList){
				RespTextBean text = (RespTextBean)object;
				for(CustomRespBean bean:(ArrayList<CustomRespBean>)CustomRespList){
					if(text.getReqKey().equals(bean.getReqKey())){
						RespReturnBean returnBean = new RespReturnBean();
						returnBean.setContent(text.getContent());
						returnBean.setReqChar(bean.getReqChar());
						returnBean.setReqContent(bean.getReqContent());
						list.add(returnBean);
					}
				}
			}
			
		}
		if("music".equals(type)){
			for(Object object:ObjectList){
				RespMusicBean text = (RespMusicBean)object;
				for(CustomRespBean bean:(ArrayList<CustomRespBean>)CustomRespList){
					if(text.getReqKey().equals(bean.getReqKey())){
						RespReturnBean returnBean = new RespReturnBean();
						returnBean.setContent(text.getContent());
						returnBean.setReqChar(bean.getReqChar());
						returnBean.setReqContent(bean.getReqContent());
						list.add(returnBean);
					}
				}
			}
		}
		if("image".equals(type)){
			for(Object object:ObjectList){
				RespImageBean text = (RespImageBean)object;
				for(CustomRespBean bean:(ArrayList<CustomRespBean>)CustomRespList){
					if(text.getReqKey().equals(bean.getReqKey())){
						RespReturnBean returnBean = new RespReturnBean();
						returnBean.setContent(text.getContent());
						returnBean.setReqChar(bean.getReqChar());
						returnBean.setReqContent(bean.getReqContent());
						list.add(returnBean);
					}
				}
			}
		}
		if("link".equals(type)){
			for(Object object:ObjectList){
				RespLinkBean text = (RespLinkBean)object;
				for(CustomRespBean bean:(ArrayList<CustomRespBean>)CustomRespList){
					if(text.getReqKey().equals(bean.getReqKey())){
						RespReturnBean returnBean = new RespReturnBean();
						returnBean.setContent(text.getContent());
						returnBean.setReqChar(bean.getReqChar());
						returnBean.setReqContent(bean.getReqContent());
						list.add(returnBean);
					}
				}
			}
		}
		if("news".equals(type)){//新闻特殊处理，暂不处理
			for(Object object:ObjectList){
				RespNewsBean text = (RespNewsBean)object;
				for(CustomRespBean bean:(ArrayList<CustomRespBean>)CustomRespList){
					if(text.getReqKey().equals(bean.getReqKey())){
						RespReturnBean returnBean = new RespReturnBean();
						returnBean.setContent(text.getDescription());
						returnBean.setReqChar(bean.getReqChar());
						returnBean.setReqContent(bean.getReqContent());
						list.add(returnBean);
					}
				}
			}
		}
		if("function".equals(type)){
			for(Object object:ObjectList){
				RespFunctionBean text = (RespFunctionBean)object;
				for(CustomRespBean bean:(ArrayList<CustomRespBean>)CustomRespList){
					if(text.getReqKey().equals(bean.getReqKey())){
						RespReturnBean returnBean = new RespReturnBean();
						returnBean.setContent(text.getContent());
						returnBean.setReqChar(bean.getReqChar());
						returnBean.setReqContent(bean.getReqContent());
						list.add(returnBean);
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
