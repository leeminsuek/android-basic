package com.shoki.dev.android_basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shoki.dev.basic.util.SLog;

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

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter();
        adapter.addItems(ShokiRepo.getItems());
        adapter.setHeaderItem(new HeaderView(this));
        adapter.setOnItemClickListener((adapter1, position) -> ShokiRepo.getItemsSortByName());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

}

