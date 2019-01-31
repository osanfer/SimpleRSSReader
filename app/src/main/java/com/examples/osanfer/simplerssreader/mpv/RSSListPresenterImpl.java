package com.examples.osanfer.simplerssreader.mpv;

import com.examples.osanfer.simplerssreader.pojo.Channel;
import com.examples.osanfer.simplerssreader.service.RSSServiceImpl;
import com.examples.osanfer.simplerssreader.service.RSSServiceInterface;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RSSListPresenterImpl implements RSSListPresenter {
    RSSListView view;

    public RSSListPresenterImpl(RSSListView view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        view.showProgress();
        RSSServiceImpl.getRestInterface().getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Channel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //Nothing to do
                    }

                    @Override
                    public void onNext(Channel channel) {
                        view.showData(channel);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError("An error occurred reading RSS");
                        view.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        view.showComplete();
                        view.hideProgress();
                    }
                });
    }
}
