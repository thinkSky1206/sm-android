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

package com.liuwuping.sm.ui.tags;

import com.liuwuping.sm.data.DataManager;
import com.liuwuping.sm.model.Repo;
import com.liuwuping.sm.model.Tag;
import com.liuwuping.sm.ui.base.BasePresenter;

import java.util.List;

/**
 * Author:liuwuping
 * Date: 2016/6/17
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:
 */
public class TagDetailPresenter extends BasePresenter<TagDetailContract.View> implements TagDetailContract.Presenter {

    public TagDetailPresenter(TagDetailContract.View view) {
        attachView(view);
    }

    @Override
    public void loadRepos(Tag tag) {
        List<Repo> repos = DataManager.getReposByTag(tag);
        getMvpView().showRepoList(repos);
    }

    @Override
    public void update(Tag tag) {
        DataManager.updateTag(tag);
        getMvpView().showToast();
    }

    @Override
    public void updateRepo(Repo repo) {
        DataManager.updateRepo(repo);
    }

}
