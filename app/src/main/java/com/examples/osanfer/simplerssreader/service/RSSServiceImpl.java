package com.examples.osanfer.simplerssreader.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RSSServiceImpl {
    private RSSServiceImpl () {
        // To avoid instantiation
    }

    public static RSSServiceInterface getRestInterface() {
        return new Retrofit.Builder()
                .baseUrl("https://www.nasa.gov/")
//                .baseUrl("http://www.xatakandroid.com/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build().create(RSSServiceInterface.class);
    }
}