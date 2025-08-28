package com.diworksdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.ecsite.dao.BuyItemDAO;
import com.diworksdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	public String execute() {
		String result = "login";
		if (session.containsKey("login_user_id")) {  //ログイン済み判定を行う
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("id", buyItemDTO.getId());                //DBから取得下商品情報をsessionに格納
			session. put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			result = SUCCESS;
		}
		return result;  //ログインはSUCCESS、ログインしてないとloginを返す
	}
	
	@Override
	public void setSession(Map<String, Object>	session){
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}


}
