package com.examples.osanfer.simplerssreader.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

public class Link {
    @Attribute(required = false)
    private String href;

    @Attribute(required = false)
    private String rel;

    @Attribute(required = false)
    private String type;

    @Text(required = false)
    private String link;
}