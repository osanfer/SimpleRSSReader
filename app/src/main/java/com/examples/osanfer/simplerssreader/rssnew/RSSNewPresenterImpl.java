package com.examples.osanfer.simplerssreader.rssnew;

import android.content.SharedPreferences;

import com.examples.osanfer.simplerssreader.pojo.Item;
import com.google.gson.Gson;

public class RSSNewPresenterImpl implements RSSNewPresenter {
    private RSSNewView view;
    //TODO Move Shared preferences logic to another layer
    private SharedPreferences sp;

    public RSSNewPresenterImpl(RSSNewView view, SharedPreferences sp) {
        this.view = view;
        this.sp = sp;
    }

    @Override
    public void loadData() {
        view.showProgress();
        view.showData(loadDataFromSP());
        view.hideProgress();
    }

    @Override
    public void onButtonClick() {
        view.launchIntent(loadDataFromSP().getLink());
    }

    private Item loadDataFromSP() {
        Gson gson = new Gson();
        String json = sp.getString("queryNew", null);
        return gson.fromJson(json, Item.class);
    }
}
