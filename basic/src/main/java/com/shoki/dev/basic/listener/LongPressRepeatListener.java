package com.shoki.dev.basic.listener;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

/***
 * 롱 프레스 리스너
 *
 * # : RepeatListener
 */
public class LongPressRepeatListener implements OnTouchListener {

    private Handler handler = new Handler();

    private int initialInterval;
    private final int normalInterval;
    private final OnClickListener clickListener;

    private Runnable handlerRunnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, normalInterval);
            clickListener.onClick(downView);
        }
    };

    private View downView;

    public LongPressRepeatListener(int initialInterval, int normalInterval, OnClickListener clickListener) {
        if (clickListener == null)
            throw new IllegalArgumentException("null runnable");
        if (initialInterval < 0 || normalInterval < 0)
            throw new IllegalArgumentException("negative interval");

        this.initialInterval = initialInterval;
        this.normalInterval = normalInterval;
        this.clickListener = clickListener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
        case MotionEvent.ACTION_DOWN:
            handler.removeCallbacks(handlerRunnable);
            handler.postDelayed(handlerRunnable, initialInterval);
            downView = view;
            clickListener.onClick(view);
            return true;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
            handler.removeCallbacks(handlerRunnable);
            downView = null;
            return true;
        }

        return false;
    }

}