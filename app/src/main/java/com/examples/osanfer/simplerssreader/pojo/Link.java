package com.examples.osanfer.simplerssreader.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

public class Link {
    @Attribute(required = false)
    public String href;

    @Attribute(required = false)
    public String rel;

    @Attribute(required = false)
    public String type;

    @Text(required = false)
    public String link;
}