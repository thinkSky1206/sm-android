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

package com.liuwuping.sm;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.liuwp.androidtoolkit.utils.L;
import com.liuwuping.sm.data.local.SharedPrefHelper;
import com.orhanobut.logger.LogLevel;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.squareup.leakcanary.LeakCanary;


/**
 * Author:liuwuping
 * Date: 16/4/21
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:
 */
public class SmApplication extends Application {

    private static final String TAG = "sm";

    @Override
    public void onCreate() {
        super.onCreate();
        L.ii("application init");
        LeakCanary.install(this);
        L.init(TAG)                     // default PRETTYLOGGER or use just init()
                .setMethodCount(1)         // default 2
                .hideThreadInfo()             // default shown
                .setMethodOffset(1);           // default 0
        L.init(TAG).setLogLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE);
        //sharedPref
        SharedPrefHelper.init(getApplicationContext());
        //orm
        FlowManager.init(new FlowConfig.Builder(this).build());
        //Stetho
        Stetho.initializeWithDefaults(this);
    }
}
