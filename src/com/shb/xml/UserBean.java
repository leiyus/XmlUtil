package com.shb.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("user_bean")
public class UserBean {

	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
