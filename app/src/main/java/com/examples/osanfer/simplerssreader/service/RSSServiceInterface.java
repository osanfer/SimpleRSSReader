package com.examples.osanfer.simplerssreader.service;

import com.examples.osanfer.simplerssreader.pojo.Channel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RSSServiceInterface {
    @GET("tag/feeds/rss2.xml")
    Observable<Channel> getData();
}