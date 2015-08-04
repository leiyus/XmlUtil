package com.shb.xml;

public class FieldAlias {
	private String alias;
	private Class<?> cla;
	private String fieldName;

	public FieldAlias(String alias, Class<?> cla, String fieldName) {
		this.alias = alias;
		this.cla = cla;
		this.fieldName = fieldName;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Class<?> getCla() {
		return this.cla;
	}

	public void setCla(Class<?> cla) {
		this.cla = cla;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
