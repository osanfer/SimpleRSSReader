package com.examples.osanfer.simplerssreader.rsslist.mvp;

import com.examples.osanfer.simplerssreader.pojo.RSSRespone;
import com.examples.osanfer.simplerssreader.service.RSSServiceImpl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RSSListPresenterImpl implements RSSListPresenter {
    RSSListView view;

    public RSSListPresenterImpl(RSSListView view) {
        this.view = view;
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
                } else {
                    view.showError("An error occurred reading RSS");
                }
                view.hideProgress();
            }

            @Override
            public void onFailure(Call<RSSRespone> call, Throwable t) {
                view.showError("An error occurred reading RSS");
                view.hideProgress();
            }
        });
    }
}
