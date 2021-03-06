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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.liuwp.androidtoolkit.recyclerview.itemdecoration.SimpleDividerDecoration;
import com.liuwp.androidtoolkit.recyclerview.itemevent.SwipeDeleteCallback;
import com.liuwuping.sm.R;
import com.liuwuping.sm.model.Repo;
import com.liuwuping.sm.model.Tag;
import com.liuwuping.sm.ui.base.BaseActivity;
import com.liuwuping.sm.ui.trending.RepoAdapter;

import java.util.List;

import butterknife.Bind;

/**
 * Author:liuwuping
 * Date: 2016/6/15
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:
 */
public class TagDetailActivity extends BaseActivity implements TagDetailContract.View {

    @Bind(R.id.toolbar_tag)
    Toolbar toolbar;
    @Bind(R.id.til_tagdetail_name)
    TextInputLayout nameEdit;
    @Bind(R.id.til_tagdetail_desc)
    TextInputLayout descEdit;
    @Bind(R.id.rv_tagdetail)
    RecyclerView recyclerView;

    private TagDetailPresenter presenter;
    private RepoAdapter adapter;
    private Tag tag;
    private List<Repo> repoList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagdetail);
        initToolbar(toolbar);
        Bundle bundle = getIntent().getExtras();
        tag = (Tag) bundle.getSerializable("tag");
        nameEdit.getEditText().setText(tag.getName());
        descEdit.getEditText().setText(tag.getDesc());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleDividerDecoration decoration = new SimpleDividerDecoration(this);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setHasFixedSize(true);
        adapter = new RepoAdapter();
        recyclerView.setAdapter(adapter);

        SwipeDeleteCallback swipeDeleteCallback = new SwipeDeleteCallback(this, new SwipeDeleteCallback.OnItemSwiped() {
            @Override
            public void onSwiped(int pos) {
                Repo repo = repoList.get(pos);
                repo.setTagId(-1);
                presenter.updateRepo(repo);
                adapter.removeItem(pos);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeDeleteCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


        presenter = new TagDetailPresenter(this);
        presenter.loadRepos(tag);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_done:
                String name = nameEdit.getEditText().getText().toString();
                String desc = descEdit.getEditText().getText().toString();
                tag.setName(name);
                tag.setDesc(desc);
                presenter.update(tag);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showRepoList(List<Repo> repos) {
        this.repoList = repos;
        adapter.setItems(repos);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showToast() {
        Snackbar snackbar = Snackbar.make(recyclerView, getResources().getString(R.string.tagdetail_suc), Snackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        int snackbarTextId = android.support.design.R.id.snackbar_text;
        TextView textView = (TextView) snackbarView.findViewById(snackbarTextId);
        textView.setTextColor(getResources().getColor(R.color.white));
        snackbar.show();
    }
}
