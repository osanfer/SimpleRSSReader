package com.examples.osanfer.simplerssreader.rsslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.examples.osanfer.simplerssreader.R;
import com.examples.osanfer.simplerssreader.rsslist.mvp.RSSListPresenterImpl;
import com.examples.osanfer.simplerssreader.rsslist.mvp.RSSListView;
import com.examples.osanfer.simplerssreader.pojo.Item;

import java.util.List;

public class RSSListActivity extends AppCompatActivity implements RSSListView {

    RSSListPresenterImpl presenter;
    ProgressBar progressBar;
    RSSItemAdapter itemAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_list);
        progressBar = findViewById(R.id.progressBar);
        presenter = new RSSListPresenterImpl(this);
        itemAdapter = new RSSItemAdapter();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);
        presenter.loadData();
    }

    @Override
    public void showData(List<Item> data) {
        itemAdapter.setData(data);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
