package com.shoki.dev.basic.widget.DiagonalScrollView;

/**
 * Created by shoki on 2017. 4. 12..
 */

public interface IDiagonalScroll {
    /**
     * <p><b>Method Name : </b>getHorizontalX</p>
     * <b>Description :</b>
     * <p>x값 변동에 따른 값 반환</p>
     *
     * @param x void
     * @since 2014. 8. 24.
     */
    public void getHorizontalX(int x);

    /**
     * <p><b>Method Name : </b>getVerticalY</p>
     * <b>Description :</b>
     * <p>y값 변동에 따른 값 반환</p>
     *
     * @param y void
     * @since 2014. 8. 24.
     */
    public void getVerticalY(int y);
}
