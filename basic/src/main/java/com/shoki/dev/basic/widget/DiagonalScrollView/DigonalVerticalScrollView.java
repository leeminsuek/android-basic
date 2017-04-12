package com.shoki.dev.basic.widget.DiagonalScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by shoki on 2017. 4. 12..
 */

public class DigonalVerticalScrollView extends ScrollView {
    /**
     * y축 변경값을 반환할 리스너
     */
    private IDiagonalScroll _scrollInter;
    public DigonalVerticalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /** <p><b>Method Name : </b>setHorizontalScroll</p>
     * <b>Description :</b>
     * <p>리스너 등록</p>
     *
     * @since 2014. 8. 24.
     * @param scrollInter
     * void
     */
    public void setHorizontalScroll(IDiagonalScroll scrollInter)
    {
        _scrollInter = scrollInter;
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        _scrollInter.getVerticalY(t);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
