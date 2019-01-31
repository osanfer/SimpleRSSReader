package com.examples.osanfer.simplerssreader.service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RSSServiceImpl {
    private RSSServiceImpl () {
        // To avoid instantiation
    }

    public static RSSServiceInterface getRestInterface() {
        return new Retrofit.Builder()
                .baseUrl("http://www.xatakandroid.com/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(RSSServiceInterface.class);
    }
}