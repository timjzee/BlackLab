package org.ivdnt.blacklab.aggregator.helper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;

public class MapAdapter extends XmlAdapter<MapWrapper, Map<String, Object>> {
    @Override
    public MapWrapper marshal(Map<String, Object> m) {
        MapWrapper wrapper = new MapWrapper();
        List elements = new ArrayList();
        for (Map.Entry<String, Object> property : m.entrySet()) {

            if (property.getValue() instanceof Map) {
                elements.add(new JAXBElement<>(new QName(getCleanLabel(property.getKey())),
                        MapWrapper.class, marshal((Map) property.getValue())));
            } else {
                elements.add(new JAXBElement<>(new QName(getCleanLabel(property.getKey())),
                        String.class, property.getValue().toString()));
            }
        }
        wrapper.elements = elements;
        return wrapper;
    }

    @Override
    public Map<String, Object> unmarshal(MapWrapper v) {
        Map<String, Object> returnval = new LinkedHashMap();
        for (Object o : v.elements) {
            Element e = (Element) o;
            if (e.getChildNodes().getLength() > 1) {
                MapWrapper mw = new MapWrapper();
                mw.elements = new ArrayList();
                for (int count = 0; count < e.getChildNodes().getLength(); count++) {
                    if (e.getChildNodes().item(count) instanceof Element) {
                        mw.elements.add(e.getChildNodes().item(count));
                    }
                }
                returnval.put(e.getTagName(), unmarshal(mw));
            } else {
                returnval.put(e.getTagName(), e.getTextContent());
            }
        }
        return returnval;
    }


    // Return a XML-safe attribute.  Might want to add camel case support
    private String getCleanLabel(String attributeLabel) {
        attributeLabel = attributeLabel.replaceAll("[()]", "").replaceAll("[^\\w\\s]", "_").replaceAll(" ", "_");
        return attributeLabel;
    }
}