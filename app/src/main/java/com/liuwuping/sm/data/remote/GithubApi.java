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

package com.liuwuping.sm.data.remote;

import com.google.gson.JsonObject;
import com.liuwuping.sm.model.Repo;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author:liuwuping
 * Date: 16/4/24
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:
 */
public interface GithubApi {


    @Headers("Accept: application/json")
    @POST("authorizations")
    Observable<JsonObject> login(@Header("Authorization") String authorization, @Body JsonObject request);


    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("https://github.com/login/oauth/access_token")
    Observable<JsonObject> getAccessToken(@Field("client_id") String client,
                                               @Field("client_secret") String clientSecret, @Field("code") String code);


    @POST("user")
    Observable<JsonObject> getUserInfo();


    @GET("user/starred?page=1")
    Observable<List<Repo>> getUserStars();


    @GET("users/{username}/starred")
    Observable<List<JsonObject>> getStarsByUser(@Path("username") String username);


    @GET("http://trending.codehub-app.com/v2/trending?since=weekly")
    Observable<List<Repo>> getTrendingRepos(@Query("language") String language);


}
