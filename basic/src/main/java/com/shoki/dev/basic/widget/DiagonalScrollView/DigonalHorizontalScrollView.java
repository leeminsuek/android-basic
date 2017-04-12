package com.shoki.dev.basic.widget.DiagonalScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by shoki on 2017. 4. 12..
 */

public class DigonalHorizontalScrollView extends HorizontalScrollView {
    private IDiagonalScroll _scrollInter;
    public DigonalHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // megabox Auto-generated constructor stub
    }

    /** <p><b>Method Name : </b>setHorizontalScroll</p>
     * <b>Description :</b>
     * <p>x축 변경값 획득 리스너 등록</p>
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

        _scrollInter.getHorizontalX(l);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
