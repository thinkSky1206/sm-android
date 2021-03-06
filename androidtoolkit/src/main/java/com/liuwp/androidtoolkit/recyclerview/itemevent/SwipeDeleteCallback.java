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

package com.liuwp.androidtoolkit.recyclerview.itemevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextPaint;
import android.view.View;

import com.liuwp.androidtoolkit.R;


/**
 * Author:liuwuping
 * Date: 2016/6/20
 * Email:liuwuping1206@163.com|liuwuping1206@gmail.com
 * Description:滑动删除
 */
public class SwipeDeleteCallback extends ItemTouchHelper.SimpleCallback {
    private Paint p;
    private TextPaint textPaint;
    private OnItemSwiped onItemSwiped;
    private String text;
    private int textSize;


    public SwipeDeleteCallback(Context context, OnItemSwiped swipedInterface) {
        super(0, ItemTouchHelper.START);
        this.onItemSwiped = swipedInterface;
        this.text = context.getResources().getString(R.string.action_remove);
        this.textSize = context.getResources().getDimensionPixelSize(R.dimen.sp12);
        p = new Paint();
        textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(textSize);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        onItemSwiped.onSwiped(position);
    }


    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        Bitmap icon;
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            View itemView = viewHolder.itemView;
            float contentHeight = itemView.getBottom() - itemView.getTop() - itemView.getPaddingTop() - itemView.getPaddingBottom();
            if (dX > 0) {//从左向右滑

            } else {//从右向左滑
                p.setColor(Color.RED);
                RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
                c.drawRect(background, p);

                float textWidth = textPaint.measureText(text);
                float textX = itemView.getWidth() - itemView.getPaddingRight() - textWidth;
                float textY = itemView.getTop() + itemView.getPaddingTop() + contentHeight / 2
                        + ((Math.abs(textPaint.ascent() - Math.abs(textPaint.descent()))) / 2);
                c.drawText(text, textX, textY, textPaint);
            }
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    public interface OnItemSwiped {
        void onSwiped(int pos);
    }
}
