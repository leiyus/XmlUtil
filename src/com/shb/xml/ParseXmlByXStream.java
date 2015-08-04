package com.shb.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class ParseXmlByXStream {
	public static Object fromXML(String xml, Class<?> clazz) {
		return fromXML(xml, null, null, null, null, clazz);
	}

	public static Object fromXML(String xml, TypeAlias[] typeAliasArray,
			Class<?> clazz) {
		return fromXML(xml, typeAliasArray, null, null, null, clazz);
	}

	public static Object fromXML(String xml, TypeAlias[] typeAliasArray,
			FieldAlias[] fieldAliasArray, Class<?> clazz) {
		return fromXML(xml, typeAliasArray, null, fieldAliasArray, null, clazz);
	}

	public static Object fromXML(String xml, TypeAlias[] typeAliasArray,
			FieldOmit[] fieldOmitArray, FieldAlias[] fieldAliasArray,
			AttributeAlias[] attributesAliasArray, Class<?> clazz) {
		XStream xstream = new XStream(new DomDriver());
		if (clazz != null) {
			xstream.processAnnotations(clazz);
		}
		if (typeAliasArray != null) {
			for (TypeAlias alias : typeAliasArray) {
				xstream.alias(alias.getName(), alias.getCla());
			}
		}
		if (fieldOmitArray != null) {
			for (FieldOmit fieldOmit : fieldOmitArray) {
				xstream.omitField(fieldOmit.getCla(), fieldOmit.getFieldName());
			}
		}
		if (fieldAliasArray != null) {
			for (FieldAlias fieldAlias : fieldAliasArray) {
				xstream.aliasField(fieldAlias.getAlias(), fieldAlias.getCla(),
						fieldAlias.getFieldName());
			}
		}
		if (attributesAliasArray != null) {
			for (AttributeAlias attributeAlias : attributesAliasArray) {
				xstream.useAttributeFor(attributeAlias.getFieldName(),
						attributeAlias.getCla());
				if (attributeAlias.getAlias() != null) {
					xstream.aliasAttribute(attributeAlias.getCla(),
							attributeAlias.getFieldName(),
							attributeAlias.getAlias());
				}
			}
		}

		return xstream.fromXML(xml);
	}
}
