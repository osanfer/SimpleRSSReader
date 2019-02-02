package com.examples.osanfer.simplerssreader.service;

import com.examples.osanfer.simplerssreader.pojo.RSSRespone;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RSSServiceInterface {
    @GET("/rss/dyn/breaking_news.rss")
//    @GET("tag/feeds/rss2.xml")
    Call<RSSRespone> getData();
}