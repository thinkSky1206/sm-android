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

package com.liuwuping.sm.ui.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Author:liuwuping
 * Date: 16/4/24
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:
 */
public class BasePresenter<T extends MvpView> implements MvpPresenter<T> {

    private T mvpView;
    private CompositeSubscription compositeSubscription;

    @Override
    public void attachView(T view) {
        mvpView = view;
    }

    @Override
    public void detachView() {
        mvpView = null;
        unSubscribe();
    }

    /**
     * 获取View接口
     *
     * @return
     */
    public T getMvpView() {
        return mvpView;
    }

    /**
     * 检查View是否销毁
     */
    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call MvpPresenter.attachView(MvpView) before" +
                    " requesting data to the MvpPresenter");
        }
    }

    /**
     * 添加订阅
     *
     * @param s
     */
    public void addSubscription(Subscription s) {
        if (this.compositeSubscription == null) {
            this.compositeSubscription = new CompositeSubscription();
        }
        this.compositeSubscription.add(s);
    }


    /**
     * 取消订阅
     */
    public void unSubscribe() {
        if (compositeSubscription != null && compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
        }
    }


}
