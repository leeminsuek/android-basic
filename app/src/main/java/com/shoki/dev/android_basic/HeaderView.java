package com.shoki.dev.android_basic;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by shoki on 2017. 3. 28..
 */

public class HeaderView extends RelativeLayout {
    public HeaderView(Context context) {
        super(context);

        init();
    }

    public void init() {
        View.inflate(getContext(), R.layout.item_main, this);

    }

    public void change() {
        View view = findViewById(R.id.item_main_bg);
        view.setBackgroundColor(Color.BLUE);
        view.getLayoutParams().height = 350;
    }
}
