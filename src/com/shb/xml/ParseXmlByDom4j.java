package com.shb.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ParseXmlByDom4j {
	public static Map<String, String> parseXmlToMap(String text)
			throws Exception {
		Document document = DocumentHelper.parseText(text);
		Element element = document.getRootElement();

		return parseElement(element);
	}

	private static Map<String, String> parseElement(Element element) {
		Map map = new HashMap();
		Iterator iterator = element.attributeIterator();
		while (iterator.hasNext()) {
			Attribute attribute = (Attribute) iterator.next();
			map.put(attribute.getName(), attribute.getValue());
		}

		Iterator elementIterator = element.elementIterator();
		while (elementIterator.hasNext()) {
			Element subElement = (Element) elementIterator.next();
			if (subElement.isTextOnly()) {
				map.put(subElement.getName(), subElement.getText());

				Iterator subAttrIte = subElement.attributeIterator();
				while (subAttrIte.hasNext()) {
					Attribute subAttr = (Attribute) subAttrIte.next();
					map.put(subAttr.getName(), subAttr.getValue());
				}
			} else {
				Map subMap = parseElement(subElement);
				map.putAll(subMap);
			}

		}

		return map;
	}
}
