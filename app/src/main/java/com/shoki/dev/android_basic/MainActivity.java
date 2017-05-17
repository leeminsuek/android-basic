package com.shoki.dev.android_basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.shoki.dev.basic.base.adapter.multi.LoadMoreRecyclerView;
import com.shoki.dev.basic.base.adapter.multi.OnRecyclerItemClickListener;
import com.shoki.dev.basic.base.adapter.multi.RecyclerRow;
import com.shoki.dev.basic.base.adapter.multi.Section;
import com.shoki.dev.basic.util.SLog;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    MainAdapter adapter;
    private final String TAG = this.getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SLog.init();

        ButterKnife.bind(this);

        LoadMoreRecyclerView recyclerView = (LoadMoreRecyclerView) findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new MainAdapter();
//        adapter.addItems(ShokiRepo.getItems());
//        adapter.setHeaderItem(new HeaderView(this));
//        adapter.setOnItemClickListener((adapter1, position) -> ShokiRepo.getItemsSortByName());
//        recyclerView.setAdapter(adapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        TestAdapter adapter = new TestAdapter();



        List<Section> sections = new ArrayList<>();
        List<RecyclerRow<?>> rows = new ArrayList<>();
        rows.add(RecyclerRow.create("type1_HEADER", TestAdapter.TYPE_1, RecyclerRow.Location.HEADER));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));

        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("type2_ITEM", TestAdapter.TYPE_3, RecyclerRow.Location.ITEM));

        rows.add(RecyclerRow.create("type3_HEADER", TestAdapter.TYPE_2, RecyclerRow.Location.HEADER));
        sections.add(Section.create(rows, TestAdapter.SECTION_A));


//        List<RecyclerRow<?>> rows2 = new ArrayList<>();
//        rows2.add(RecyclerRow.create("type4_ITEM", TestAdapter.TYPE_3_1, RecyclerRow.Location.ITEM));
//        rows2.add(RecyclerRow.create("type5_ITEM", TestAdapter.TYPE_3_2, RecyclerRow.Location.ITEM));
//        rows2.add(RecyclerRow.create("type6_ITEM", TestAdapter.TYPE_3_3, RecyclerRow.Location.ITEM));
//        sections.add(Section.create(rows2, TestAdapter.SECTION_B));

        try {
            adapter.addSections(sections);
            adapter.setRecyclerItemClickListener(new OnRecyclerItemClickListener() {
                @Override
                public void onItemClick(Section section, int position) {
                    section.setDataRemains(true);
                    adapter.setSection(section);
                    adapter.notifyDataSetChanged();
                    new android.os.Handler().postDelayed(new TimerTask() {
                        @Override
                        public void run() {
                            int lastPosition = adapter.getSectionLastItemPosition(section);
                            adapter.addSectionItems(getItems(), section.getSectionType());
                            adapter.notifyItemRangeChanged(lastPosition, getItems().size()+1);
                        }
                    }, 1500);
                }
            });
            adapter.setDataRemains(false);
            recyclerView.setBottomListener(() -> {
                new android.os.Handler().postDelayed(() -> {
                    List<RecyclerRow<?>> rows2 = new ArrayList<>();
                    rows2.add(RecyclerRow.create("type4_ITEM", TestAdapter.TYPE_3_1, RecyclerRow.Location.ITEM));
                    rows2.add(RecyclerRow.create("type5_ITEM", TestAdapter.TYPE_3_2, RecyclerRow.Location.ITEM));
                    rows2.add(RecyclerRow.create("type6_ITEM", TestAdapter.TYPE_3_3, RecyclerRow.Location.ITEM));

                    adapter.addSection(Section.create(rows2, TestAdapter.SECTION_B));
                    recyclerView.setDataRemains(true);
                    adapter.notifyDataSetChanged();
                }, 5000);
            });

            recyclerView.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RecyclerRow<?>> getItems() {
        List<RecyclerRow<?>> rows = new ArrayList<>();
        rows.add(RecyclerRow.create("typeadd_ITEM", TestAdapter.TYPE_3_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("typeadd_ITEM", TestAdapter.TYPE_3_3, RecyclerRow.Location.ITEM));
        rows.add(RecyclerRow.create("typeadd_ITEM", TestAdapter.TYPE_3_3, RecyclerRow.Location.ITEM));
        return rows;
    }

}

