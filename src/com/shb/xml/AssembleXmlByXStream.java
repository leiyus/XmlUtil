package com.shb.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class AssembleXmlByXStream {
	public static String toXML(Object obj) {
		return toXML(obj, null, null, null, null);
	}

	public static String toXML(Object obj, TypeAlias[] typeAliasArray) {
		return toXML(obj, typeAliasArray, null, null, null);
	}

	public static String toXML(Object obj, TypeAlias[] typeAliasArray,
			FieldAlias[] fieldAliasArray) {
		return toXML(obj, typeAliasArray, null, fieldAliasArray, null);
	}

	public static String toXML(Object obj, TypeAlias[] typeAliasArray,
			FieldOmit[] fieldOmitArray, FieldAlias[] fieldAliasArray,
			AttributeAlias[] attributesAliasArray) {
		XStream xstream = new XStream(new XppDriver(new XmlFriendlyReplacer("__", "_")));
		xstream.processAnnotations(obj.getClass());
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

		return xstream.toXML(obj);
	}
}
