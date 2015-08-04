package com.shb.xml;

public class FieldOmit {
	private String fieldName;
	private Class<?> cla;

	public FieldOmit(String fieldName, Class<?> cla) {
		this.fieldName = fieldName;
		this.cla = cla;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Class<?> getCla() {
		return this.cla;
	}

	public void setCla(Class<?> cla) {
		this.cla = cla;
	}
}
