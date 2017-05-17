package com.shoki.dev.android_basic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shoki.dev.basic.base.adapter.multi.BaseSectionRecyclerAdapter;
import com.shoki.dev.basic.base.adapter.multi.BaseViewHolder;
import com.shoki.dev.basic.base.adapter.multi.Section;

import butterknife.BindView;

/**
 * Created by shoki on 2017. 5. 17..
 */

public class TestAdapter extends BaseSectionRecyclerAdapter {


    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_3_1 = 34;
    public static final int TYPE_3_2 = 35;
    public static final int TYPE_3_3 = 36;

    public static final int SECTION_A = 11;
    public static final int SECTION_B = 22;
    public static final int SECTION_C = 33;

    @Override
    public BaseViewHolder onAbstractCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_1) {
            return new TYPE1(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type1, parent, false));
        } else if(viewType == TYPE_2) {
            return new TYPE2(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type2, parent, false));
        } else if(viewType == TYPE_3) {
            return new TYPE3(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type3, parent, false));
        } else if(viewType == TYPE_3_2) {
            return new TYPE4(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type4, parent, false));
        } else if(viewType == TYPE_3_3) {
            return new TYPE5(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type5, parent, false));
        } else if(viewType == TYPE_3_1) {
            return new TYPE6(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type6, parent, false));
        } else {
            return new TYPE7(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_type7, parent, false));
        }
    }

    public class TYPE1 extends BaseViewHolder {
        @BindView(R.id.txtv)
        TextView textView;
        public TYPE1(View view) {
            super(view);
        }

        @Override
        public void onBindViewHolder(Object item, int position, Section section) {
            textView.setText((String)item);
        }
    }

    public class TYPE2 extends BaseViewHolder {
        @BindView(R.id.txtv)
        TextView textView;
        public TYPE2(View view) {
            super(view);
            view.setOnClickListener(v -> {
                if(mRecyclerItemClickListener != null) {
                    mRecyclerItemClickListener.onItemClick(getSection(getAdapterPosition()), getAdapterPosition());
                }
            });
        }

        @Override
        public void onBindViewHolder(Object item, int position, Section section) {
            textView.setText((String)item);
        }
    }

    public class TYPE3 extends BaseViewHolder {
        @BindView(R.id.txtv)
        TextView textView;
        public TYPE3(View view) {
            super(view);
        }

        @Override
        public void onBindViewHolder(Object item, int position, Section section) {
            textView.setText((String)item);
        }
    }

    public class TYPE4 extends BaseViewHolder {
        @BindView(R.id.txtv)
        TextView textView;
        public TYPE4(View view) {
            super(view);
        }

        @Override
        public void onBindViewHolder(Object item, int position, Section section) {
            textView.setText((String)item);
        }
    }

    public class TYPE5 extends BaseViewHolder {
        @BindView(R.id.txtv)
        TextView textView;
        public TYPE5(View view) {
            super(view);
        }

        @Override
        public void onBindViewHolder(Object item, int position, Section section) {
            textView.setText((String)item);
        }
    }

    public class TYPE6 extends BaseViewHolder {
        @BindView(R.id.txtv)
        TextView textView;
        public TYPE6(View view) {
            super(view);
        }

        @Override
        public void onBindViewHolder(Object item, int position, Section section) {
            textView.setText((String)item);
        }
    }

    public class TYPE7 extends BaseViewHolder {
        @BindView(R.id.txtv)
        TextView textView;
        public TYPE7(View view) {
            super(view);
        }

        @Override
        public void onBindViewHolder(Object item, int position, Section section) {
            textView.setText((String)item);
        }
    }

}
