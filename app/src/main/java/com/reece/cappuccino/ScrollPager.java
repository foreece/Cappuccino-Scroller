package com.reece.cappuccino;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 类似ViewPager on 17-1-22.
 */

public class ScrollPager extends ViewGroup {

    private float mLastPosition;

    public ScrollPager(Context context) {
        this(context, null);
    }

    public ScrollPager(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            measureChild(getChildAt(i), widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            int childCount = getChildCount();
            int childWidth = childCount != 0 ? getChildAt(0).getMeasuredWidth() : 0;
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                child.layout(i * childWidth, 0, (i + 1) * childWidth, getMeasuredHeight());
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getRawX();
        float y = event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastPosition = x;
                break;
            case MotionEvent.ACTION_MOVE:
                int move = (int) (mLastPosition - x);
                scrollBy(move, 0);
                mLastPosition = x;
                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_CANCEL:

                break;
        }
        return true;
    }
}
