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
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import com.liuwp.androidtoolkit.recyclerview.itemevent.RecyclerItemClickSupport;
import com.liuwp.androidtoolkit.recyclerview.itemevent.SwipeDeleteCallback;
import com.liuwuping.sm.R;
import com.liuwuping.sm.model.Tag;
import com.liuwuping.sm.ui.base.BaseFragment;
import com.liuwp.androidtoolkit.recyclerview.itemdecoration.SimplePaddingDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

/**
 * Author:liuwuping
 * Date: 16/4/24
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:所有的tag列表
 */
public class TagsFragment extends BaseFragment implements TagsContract.View {

    private static final Interpolator INTERPOLATOR = new AccelerateDecelerateInterpolator();

    @Bind(R.id.view_addtag)
    View addTagView;
    @Bind(R.id.til_addtag_name)
    TextInputLayout nameEdit;
    @Bind(R.id.til_addtag_desc)
    TextInputLayout descEdit;
    @Bind(R.id.rv_tags)
    RecyclerView recyclerView;

    private MenuItem menuItem;
    private TagsPresenter presenter;
    private TagAdapter adapter;
    private List<Tag> tagList = null;

    public static TagsFragment newInstance() {
        TagsFragment fragment = new TagsFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter = new TagsPresenter(this);
        presenter.loadTags();
    }


    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        SimplePaddingDecoration decoration = new SimplePaddingDecoration(this.getActivity(), R.dimen.dp16, R.dimen.dp16, R.dimen.dp10, 0);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setHasFixedSize(true);
        adapter = new TagAdapter();
        recyclerView.setAdapter(adapter);

        SwipeDeleteCallback swipeDeleteCallback = new SwipeDeleteCallback(getActivity(),new SwipeDeleteCallback.OnItemSwiped() {
            @Override
            public void onSwiped(int pos) {
                presenter.removeTag(tagList.get(pos));
                adapter.removeItem(pos);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeDeleteCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        RecyclerItemClickSupport.addTo(recyclerView).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Tag tag = tagList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("tag", tag);
                switchActivity(TagDetailActivity.class, bundle);
            }
        });
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.frag_tags;
    }

    @Override
    protected View getLoadingTargetView() {
        return recyclerView;
    }

    @OnClick(R.id.btn_addtag)
    public void onClick(View view) {
        String name = nameEdit.getEditText().getText().toString();
        String desc = descEdit.getEditText().getText().toString();
        Tag tag = new Tag();
        tag.setName(name);
        tag.setDesc(desc);
        presenter.saveTag(tag);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add, menu);
        menuItem = menu.getItem(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                toggleAddTagView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showTags(List<Tag> tags) {
        this.tagList = tags;
        adapter.setItems(tags);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void toggleAddTagView() {
        if (addTagView.getVisibility() != View.VISIBLE) {
            revealOn();
            nameEdit.getEditText().setText("");
            descEdit.getEditText().setText("");
            menuItem.setIcon(R.drawable.all_close);
        } else {
            revealOff();
            menuItem.setIcon(R.drawable.all_add);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }


    private void revealOn() {
        int cx = addTagView.getRight();
        int cy = addTagView.getTop();
        float radius = (float) Math.hypot(addTagView.getWidth(), addTagView.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(addTagView, cx, cy, 0, radius);
        animator.setInterpolator(INTERPOLATOR);
        animator.setDuration(getResources().getInteger(R.integer.view_reveal_mills));
        animator.addListener(new SupportAnimator.AnimatorListener() {
            @Override
            public void onAnimationStart() {
                addTagView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd() {
                // Do nothing
            }

            @Override
            public void onAnimationCancel() {
                // Do nothing
            }

            @Override
            public void onAnimationRepeat() {
                // Do nothing
            }
        });

        animator.start();
    }


    public void revealOff() {
        int cx = addTagView.getRight();
        int cy = addTagView.getTop();
        float radius = (float) Math.hypot(addTagView.getWidth(), addTagView.getHeight());
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(addTagView, cx, cy, radius, 0);
        animator.setInterpolator(INTERPOLATOR);
        animator.setDuration(getResources().getInteger(R.integer.view_reveal_mills));
        animator.addListener(new SupportAnimator.AnimatorListener() {
            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationEnd() {
                addTagView.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationCancel() {
                // Do nothing
            }

            @Override
            public void onAnimationRepeat() {
            }
        });
        animator.start();
    }

}
