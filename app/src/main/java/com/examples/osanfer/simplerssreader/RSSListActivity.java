package com.examples.osanfer.simplerssreader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.examples.osanfer.simplerssreader.mpv.RSSListPresenterImpl;
import com.examples.osanfer.simplerssreader.mpv.RSSListView;
import com.examples.osanfer.simplerssreader.pojo.Channel;

public class RSSListActivity extends AppCompatActivity implements RSSListView {

    RSSListPresenterImpl presenter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_list);
        progressBar = findViewById(R.id.progressBar);
        presenter = new RSSListPresenterImpl(this);
        presenter.loadData();
    }

    @Override
    public void showData(Channel data) {

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
