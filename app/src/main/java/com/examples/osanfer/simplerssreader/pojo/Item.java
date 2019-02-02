package com.examples.osanfer.simplerssreader.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "item", strict = false)
public class Item {

    @Element(name = "title", required = true)
    String title;//The title of the item.	Venice Film Festival Tries to Quit Sinking
    @Element(name = "link", required = true)
    String link;//The URL of the item.	http://www.nytimes.com/2002/09/07/movies/07FEST.html
    @Element(name = "description", required = true)
    String description;//The item synopsis.	Some of the most heated chatter at the Venice Film Festival this week was about the way that the arrival of the stars at the Palazzo del Cinema was being staged.
    @Element(name = "author", required = false)
    String author;//Email address of the author of the item. More.	oprah@oxygen.net
    @ElementList(entry = "category", inline = true, required = false)
    List<String> category;//Includes the item in one or more categories. More.	Simpsons Characters
    @Element(name = "comments", required = false)
    String comments;//URL of a page for comments relating to the item. More.	http://www.myblog.org/cgi-local/mt/mt-comments.cgi?entry_id=290
    @Element(name = "enclosure", required = false)
    Enclosure enclosure;//	Describes a media object that is attached to the item. More.	<enclosure url="http://live.curry.com/mp3/celebritySCms.mp3" length="1069871" type="audio/mpeg"/>
    @Element(name = "guid", required = false)
    String guid;//A string that uniquely identifies the item. More.	<guid isPermaLink="true">http://inessential.com/2002/09/01.php#a2</guid>
    @Element(name = "pubDate", required = false)
    String pubDate;//	Indicates when the item was published. More.	Sun, 19 May 2002 15:21:36 GMT
    @Element(name = "source", required = false)
    String source;//	The RSS channel that the item came from. More.

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