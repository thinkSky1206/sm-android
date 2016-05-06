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

package com.liuwuping.sm.view.stars;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liuwuping.sm.R;
import com.liuwuping.sm.model.Repo;
import com.liuwuping.sm.view.base.BaseFragment;
import com.liuwuping.sm.view.trending.RepoAdapter;
import com.liuwuping.sm.widget.SimplePaddingDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author:liuwuping
 * Date: 16/4/24
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:未分类的stars列表
 */
public class StarsFragment extends BaseFragment implements StarsContract.View {

    private RepoAdapter adapter;
    private StarsPresenter starsPresenter;

    @Bind(R.id.rv_stars)
    RecyclerView recyclerView;


    public static StarsFragment newInstance() {
        StarsFragment fragment = new StarsFragment();
        return fragment;
    }


    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        SimplePaddingDecoration decoration = new SimplePaddingDecoration(this.getActivity(), 0, 0, 0, R.dimen.divider_stars);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setHasFixedSize(true);
        adapter = new RepoAdapter();
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.frag_stars;
    }


    @Override
    public void showRepos(List<Repo> repos) {
        adapter.setItems(repos);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        starsPresenter = new StarsPresenter();
        starsPresenter.attachView(this);
        starsPresenter.loadRepos();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        starsPresenter.detachView();
    }


}
