package com.examples.osanfer.simplerssreader.mpv;

import com.examples.osanfer.simplerssreader.pojo.Channel;

import java.util.List;

public interface RSSListView {
    void showData(Channel data);

    void showError(String message);

    void showComplete();

    void showProgress();

    void hideProgress();
}