package org.ivdnt.blacklab.aggregator.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class FieldInfo {

    public String pidField = "";

    public String titleField = "";

    public String authorField = "";

    public String dateField = "";

    // required for Jersey
    public FieldInfo() {}

    public FieldInfo(String pidField, String titleField) {
        this.pidField = pidField;
        this.titleField = titleField;
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "pidField='" + pidField + '\'' +
                ", titleField='" + titleField + '\'' +
                ", authorField='" + authorField + '\'' +
                ", dateField='" + dateField + '\'' +
                '}';
    }
}