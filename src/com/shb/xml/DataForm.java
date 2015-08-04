package com.shb.xml;


import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("data_form")
public class DataForm {

	@XStreamAlias("user_id")
	private String userId;
	
	@XStreamAlias("user_name")
	private String userName;
	@XStreamAlias("user_address")
	private String userAddress;
	
	
	private List<UserBean> list;
	
	
	public List<UserBean> getList() {
		return list;
	}
	public void setList(List<UserBean> list) {
		this.list = list;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
}
