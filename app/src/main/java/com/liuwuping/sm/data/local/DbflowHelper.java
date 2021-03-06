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

package com.liuwuping.sm.data.local;

import com.liuwuping.sm.model.Repo;
import com.liuwuping.sm.model.Repo_Table;
import com.liuwuping.sm.model.Tag;
import com.liuwuping.sm.model.Tag_Table;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

/**
 * Author:liuwuping
 * Date: 2016/6/10
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:
 */
public class DbflowHelper {


    /**
     * Tag
     */
    public static void saveTag(Tag tag) {
        tag.save();
    }

    public static void updateTag(Tag tag) {
        tag.update();
    }

    public static void deleteTag(Tag tag) {
        tag.delete();
    }

    public static List<Tag> getAllTags() {
        return new Select().from(Tag.class).queryList();
    }

    /**
     * Repo
     */
    public static void saveRepo(Repo repo) {
        repo.save();
    }

    public static void updateRepo(Repo repo) {
        repo.update();
    }

    public static List<Repo> queryAllRepo() {
        return new Select().from(Repo.class).queryList();
    }

    public static List<Repo> queryReposByTag(Tag tag) {
        return new Select().from(Repo.class).where(Repo_Table.tagId.eq(tag.getId())).queryList();
    }
}
