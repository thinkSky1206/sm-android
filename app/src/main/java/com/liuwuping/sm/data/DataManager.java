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

package com.liuwuping.sm.data;

import com.google.gson.JsonObject;
import com.liuwp.androidtoolkit.utils.L;
import com.liuwuping.sm.data.local.DbflowHelper;
import com.liuwuping.sm.data.local.SmDatabase;
import com.liuwuping.sm.data.remote.GithubClient;
import com.liuwuping.sm.model.Repo;
import com.liuwuping.sm.model.Tag;
import com.liuwuping.sm.model.User;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Author:liuwuping
 * Date: 16/4/24
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:
 */
public class DataManager {

    public static void saveTag(Tag tag) {
        DbflowHelper.saveTag(tag);
    }

    public static void updateTag(Tag tag) {
        DbflowHelper.updateTag(tag);
    }


    public static void deleteTag(Tag tag) {
        final List<Repo> repos = DbflowHelper.queryReposByTag(tag);
        L.ii("批量处理条数：" + repos.size());
        DatabaseDefinition database = FlowManager.getDatabase(SmDatabase.class);
        database.executeTransaction(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                for (Repo repo : repos) {
                    repo.setTagId(-1);
                    repo.update(databaseWrapper);
                }
            }
        });
        DbflowHelper.deleteTag(tag);
    }

    public static List<Tag> getAllTags() {
        return DbflowHelper.getAllTags();
    }


    public static void saveRepo(Repo repo) {
        DbflowHelper.saveRepo(repo);
    }

    public static void updateRepo(Repo repo) {
        DbflowHelper.updateRepo(repo);
    }

    public static List<Repo> getReposByTag(Tag tag) {
        return DbflowHelper.queryReposByTag(tag);
    }

    public static Observable<JsonObject> login(String auth, JsonObject login) {
        return GithubClient.getInstance().get().login(auth, login);
    }

    public static Observable<JsonObject> getAccessToken(String clientId, String clientSecret, String token) {
        return GithubClient.getInstance().get().getAccessToken(clientId, clientSecret, token);
    }


    public static Observable<List<Repo>> getUserStars() {
        return GithubClient.getInstance().get().getUserStars();
    }

    public static Observable<List<JsonObject>> getStarsByUser(String username) {
        return GithubClient.getInstance().get().getStarsByUser(username);
    }

    public static Observable<List<Repo>> getTrendingRepos(String language) {
        return GithubClient.getInstance().get().getTrendingRepos(language);
    }

    public static Observable<ResponseBody> getReadmeHtml(String owner, String repo) {
        return GithubClient.getInstance().get().getReadMeHtml(owner, repo);
    }

    public static Observable<JsonObject> getReadmeUrl(String owner, String repo) {
        return GithubClient.getInstance().get().getReadMeUrl(owner, repo);
    }


    public static Observable<User> getUser(String owner) {
        return GithubClient.getInstance().get().getUserInfo(owner);
    }

    public static Observable<User> getLoginUser() {
        return GithubClient.getInstance().get().getLoginInfo();
    }

    public static Observable<List<User>> getFollowers(String username) {
        return GithubClient.getInstance().get().getFollowers(username);
    }

    public static Observable<List<User>> getFollowing(String username) {
        return GithubClient.getInstance().get().getFollowing(username);
    }

    public static Observable<List<Repo>> getUserRepos(String username) {
        return GithubClient.getInstance().get().getRepos(username);
    }

    public static Observable<JsonObject> isStar(String owner, String repo) {
        return GithubClient.getInstance().get().isStar(owner, repo);
    }

    public static Observable<JsonObject> star(String owner, String repo) {
        return GithubClient.getInstance().get().star(owner, repo);
    }

    public static Observable<JsonObject> unStar(String owner, String repo) {
        return GithubClient.getInstance().get().unStar(owner, repo);
    }


}
