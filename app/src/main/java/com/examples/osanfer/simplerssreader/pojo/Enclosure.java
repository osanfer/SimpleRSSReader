package com.examples.osanfer.simplerssreader.pojo;

import org.simpleframework.xml.Attribute;

public class Enclosure {
    @Attribute
    private String url;

    @Attribute
    private int length;

    @Attribute
    private String type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}