package com.examples.osanfer.simplerssreader.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "item", strict = false)
public class Item {

    @Element(name = "title", required = true)
    String title;
    @Element(name = "link", required = true)
    String link;
    @Element(name = "description", required = true)
    String description;
    @Element(name = "author", required = false)
    String author;
    @ElementList(entry = "category", inline = true, required = false)
    List<String> category;
    @Element(name = "comments", required = false)
    String comments;
    @Element(name = "enclosure", required = false)
    Enclosure enclosure;
    @Element(name = "guid", required = false)
    String guid;
    @Element(name = "pubDate", required = false)
    String pubDate;
    @Element(name = "source", required = false)
    String source;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}