package com.examples.osanfer.simplerssreader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.examples.osanfer.simplerssreader.mpv.RSSListPresenterImpl;
import com.examples.osanfer.simplerssreader.mpv.RSSListView;
import com.examples.osanfer.simplerssreader.pojo.Channel;

public class RSSListActivity extends AppCompatActivity implements RSSListView {

    RSSListPresenterImpl presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_list);
        presenter = new RSSListPresenterImpl(this);

        presenter.loadData();
    }

    @Override
    public void showData(Channel data) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
