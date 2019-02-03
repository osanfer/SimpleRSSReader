package com.examples.osanfer.simplerssreader.rsslist;

import android.content.SharedPreferences;

import com.examples.osanfer.simplerssreader.pojo.Item;
import com.examples.osanfer.simplerssreader.pojo.RSSRespone;
import com.examples.osanfer.simplerssreader.service.RSSServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RSSListPresenterImpl implements RSSListPresenter {
    private RSSListView view;
    //TODO Move Shared preferences logic to another layer
    private SharedPreferences sp;

    public RSSListPresenterImpl(RSSListView view, SharedPreferences sp) {
        this.view = view;
        this.sp = sp;
    }

    @Override
    public void loadData() {
        view.showProgress();
        Call<RSSRespone> call = RSSServiceImpl.getRestInterface().getData();
        call.enqueue(new Callback<RSSRespone>() {
            @Override
            public void onResponse(Call<RSSRespone> call, Response<RSSRespone> response) {
                if(response.isSuccessful()) {
                    view.showData(response.body().getChannel().getItemList());
                    SharedPreferences.Editor prefsEditor = sp.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(response.body().getChannel().getItemList().subList(0,5));
                    prefsEditor.putString("lastNews", json);
                    prefsEditor.apply();
                } else {
                    List<Item> data = loadDataFromSP();
                    if (data != null) {
                        view.showData(data);
                    } else {
                        view.showError("An error occurred reading RSS");
                    }
                }
                view.hideProgress();
            }

            @Override
            public void onFailure(Call<RSSRespone> call, Throwable t) {
                List<Item> data = loadDataFromSP();
                if (data != null) {
                    view.showData(data);
                } else {
                    view.showError("An error occurred reading RSS, showing last fetched news");
                }
                view.hideProgress();
            }
        });
    }

    @Override
    public void onItemClick(int adapterPosition) {
        SharedPreferences.Editor prefsEditor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(view.getSelectedItem(adapterPosition));
        prefsEditor.putString("queryNew", json);
        prefsEditor.apply();
        view.launchActivity();
    }

    private List<Item> loadDataFromSP() {
        Gson gson = new Gson();
        String json = sp.getString("lastNews", null);
        Type listType = new TypeToken<List<Item>>(){}.getType();
        return gson.fromJson(json, listType);
    }
}
