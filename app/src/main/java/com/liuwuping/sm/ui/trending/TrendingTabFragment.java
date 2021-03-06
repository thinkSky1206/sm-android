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

package com.liuwuping.sm.ui.trending;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.liuwp.androidtoolkit.recyclerview.itemevent.RecyclerItemClickSupport;
import com.liuwuping.sm.R;
import com.liuwuping.sm.model.Repo;
import com.liuwuping.sm.ui.base.BaseFragment;
import com.liuwp.androidtoolkit.recyclerview.itemdecoration.SimplePaddingDecoration;
import com.liuwuping.sm.ui.repodetail.RepoDetailActivity;

import java.util.List;

import butterknife.Bind;

/**
 * Author:liuwuping
 * Date: 2016/4/29
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:
 */
public class TrendingTabFragment extends BaseFragment implements TrendingTabContract.View {

    @Bind(R.id.rv_commom)
    RecyclerView recyclerView;


    private static final String LANGUAGE = "language";
    private String language;
    private RepoAdapter adapter;
    private TrendingTabPresenter presenter;
    private List<Repo> repos = null;

    public static TrendingTabFragment newInstance(String language) {
        Bundle args = new Bundle();
        args.putString(LANGUAGE, language);
        TrendingTabFragment fragment = new TrendingTabFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        language = getArguments().getString(LANGUAGE);
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        SimplePaddingDecoration decoration = new SimplePaddingDecoration(this.getActivity(),
                R.dimen.dp16, R.dimen.dp16,
                R.dimen.dp10, 0);
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

        presenter = new TrendingTabPresenter(this);
        presenter.loadRepos(language);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.frag_recycler;
    }

    @Override
    protected View getLoadingTargetView() {
        return recyclerView;
    }


    @Override
    public void showRepos(List<Repo> repos) {
        this.repos = repos;
        adapter.setItems(repos);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

}
