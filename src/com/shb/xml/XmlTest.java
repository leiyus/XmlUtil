package com.shb.xml;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class XmlTest {

	public static void main(String[] args) {

		String resul = "";
		DataForm form = new DataForm();
		form.setUserId("userId");
		form.setUserName("username");

		UserBean userBean = new UserBean();
		userBean.setId("userbeanId");
		userBean.setName("userbeanName");
		List<UserBean> list = new ArrayList<UserBean>();
		list.add(userBean);
		form.setList(list);
		resul = AssembleXmlByXStream.toXML(form);
		System.out.println("result:\n" + resul);

		StringBuffer xmlString = new StringBuffer();
		xmlString.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
		xmlString.append("<data_form>");
		xmlString.append(" <user_id>userId</user_id>");
		xmlString.append(" <user_name>username</user_name>");
		xmlString.append(" <user_address>userAddress</user_address>");
		xmlString.append("<list>");
		xmlString.append("<user_bean>");
		xmlString.append("<id>userbeanId</id>");
		xmlString.append("<name>userbeanName</name>");
		xmlString.append("</user_bean>");
		xmlString.append("</list>");
		xmlString.append("</data_form>");

		DataForm dataForm = (DataForm) ParseXmlByXStream.fromXML(
				xmlString.toString(), DataForm.class);
		System.out.println("result:\n" + dataForm.getUserId());

	}
}
