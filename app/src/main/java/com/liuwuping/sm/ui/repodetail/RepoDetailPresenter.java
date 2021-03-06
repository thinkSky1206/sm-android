/*
 *  Copyright (c) 2016 [liuwuping1206@163.com | liuwuping1206@gmail.com]
 *
 *  Licensed under the Apache License, Version 2.0 (the "License”);
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.liuwuping.sm.ui.repodetail;

import com.google.gson.JsonObject;
import com.liuwuping.sm.data.DataManager;
import com.liuwuping.sm.model.Repo;
import com.liuwuping.sm.model.Tag;
import com.liuwuping.sm.model.User;
import com.liuwuping.sm.ui.base.BasePresenter;
import com.liuwuping.sm.ui.repodetail.RepoDetailContract.Presenter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Author:liuwuping
 * Date: 2016/5/18
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:
 */
public class RepoDetailPresenter extends BasePresenter<RepoDetailContract.View> implements Presenter {


    public RepoDetailPresenter(RepoDetailContract.View view) {
        attachView(view);
    }


    @Override
    public void getReadMeUrl(String owner, String repo) {
        checkViewAttached();
        addSubscription(DataManager.getReadmeUrl(owner, repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<JsonObject>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(JsonObject result) {
                        String htmlUrl = result.get("html_url").getAsString();
                        getMvpView().showHtml(htmlUrl);
                    }
                }));

    }

    @Override
    public void getAvatarUrl(String username) {
        checkViewAttached();
        addSubscription(DataManager.getUser(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(User user) {
                        getMvpView().showHeaderImage(user.getAvatar_url());
                    }
                }));

    }

    @Override
    public void isStar(String owner, String repo) {
        checkViewAttached();
        addSubscription(DataManager.isStar(owner, repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<JsonObject>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showStarState(false);
                    }

                    @Override
                    public void onNext(JsonObject result) {
                        getMvpView().showStarState(true);
                    }
                }));

    }

    @Override
    public void star(String owner, String repo) {
        checkViewAttached();
        addSubscription(DataManager.star(owner, repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<JsonObject>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(JsonObject result) {
                        getMvpView().showStarState(true);
                    }
                }));

    }

    @Override
    public void unStar(String owner, String repo) {
        checkViewAttached();
        addSubscription(DataManager.unStar(owner, repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<JsonObject>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(JsonObject result) {
                        getMvpView().showStarState(false);
                    }
                }));

    }

    @Override
    public void loadTags() {
        List<Tag> tags = DataManager.getAllTags();
        getMvpView().showTagList(tags);


    }

    @Override
    public void addRepoToTag(Repo repo) {
        DataManager.saveRepo(repo);
        getMvpView().hiddenTagList();
    }
}
