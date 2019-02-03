package com.examples.osanfer.simplerssreader.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Channel {
    // Tricky part in Simple XML because the link is named twice
    @ElementList(entry = "link", inline = true, required = false)
    private List<Link> links;

    @ElementList(name = "item", required = true, inline = true)
    private List<Item> itemList;

    @Element(name="title")
    private String title;

    @Element(name="language", required = false)
    private String language;

    @Element(name = "ttl", required = false)
    private int ttl;

    @Element(name = "pubDate", required = false)
    private String pubDate;

    public List<Link> getLinks() {
        return links;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public int getTtl() {
        return ttl;
    }

    public String getPubDate() {
        return pubDate;
    }
}