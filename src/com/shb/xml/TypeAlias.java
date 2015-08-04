package com.shb.xml;

public class TypeAlias {
	private String name;
	private Class<?> cla;

	public TypeAlias(String name, Class<?> cla) {
		this.name = name;
		this.cla = cla;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getCla() {
		return this.cla;
	}

	public void setCla(Class<?> cla) {
		this.cla = cla;
	}
}
