package com.examples.osanfer.simplerssreader.rsslist;

import com.examples.osanfer.simplerssreader.pojo.Item;

import java.util.List;

public interface RSSListView {
    void showData(List<Item> data);

    void showError(String message);

    void showProgress();

    void hideProgress();

    void launchActivity();

    Item getSelectedItem(int adapterPosition);
}
