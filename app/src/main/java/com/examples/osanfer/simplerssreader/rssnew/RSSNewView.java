package com.examples.osanfer.simplerssreader.rssnew;

import com.examples.osanfer.simplerssreader.pojo.Item;

public interface RSSNewView {
    void showProgress();

    void hideProgress();

    void showData(Item data);

    void launchIntent(String url);
}
