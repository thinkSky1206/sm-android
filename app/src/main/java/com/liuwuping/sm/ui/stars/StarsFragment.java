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

package com.liuwuping.sm.ui.stars;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuwp.androidtoolkit.recyclerview.itemevent.RecyclerItemClickSupport;
import com.liuwp.androidtoolkit.utils.L;
import com.liuwuping.sm.R;
import com.liuwuping.sm.model.Repo;
import com.liuwuping.sm.ui.base.BaseFragment;
import com.liuwuping.sm.ui.repodetail.RepoDetailActivity;
import com.liuwuping.sm.ui.trending.RepoAdapter;
import com.liuwp.androidtoolkit.recyclerview.itemdecoration.SimplePaddingDecoration;

import java.util.List;

import butterknife.Bind;

/**
 * Author:liuwuping
 * Date: 16/4/24
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:未分类的stars列表
 */
public class StarsFragment extends BaseFragment implements StarsContract.View {

    private RepoAdapter adapter;
    private StarsPresenter starsPresenter;
    private List<Repo> repos = null;

    @Bind(R.id.rv_stars)
    RecyclerView recyclerView;
    @Bind(R.id.srl_stars)
    SwipeRefreshLayout swipeRefreshLayout;


    public static StarsFragment newInstance() {
        StarsFragment fragment = new StarsFragment();
        return fragment;
    }


    @Override
    protected void initView() {
        starsPresenter = new StarsPresenter(this);
        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                starsPresenter.loadRepos();
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        SimplePaddingDecoration decoration = new SimplePaddingDecoration(this.getActivity(), R.dimen.dp16, R.dimen.dp16, R.dimen.dp10, 0);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setHasFixedSize(true);
        adapter = new RepoAdapter();
        recyclerView.setAdapter(adapter);

        RecyclerItemClickSupport.addTo(recyclerView).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Repo repo = repos.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("repo", repo);
                switchActivity(RepoDetailActivity.class, bundle);
            }
        });

        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
        starsPresenter.loadRepos();
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.frag_stars;
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }


    @Override
    public void showRepos(List<Repo> repos) {
        this.repos = repos;
        adapter.setItems(repos);
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        starsPresenter.detachView();
    }


}
