package com.shoki.dev.android_basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    List<String> list;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        list = new ArrayList<>();
        for ( int i = 0 ; i < 100 ; i ++) {
            list.add("TEST" + i );
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MainAdapter();
        adapter.addItems(list);
        adapter.setHeaderItem(new HeaderView(this));
        recyclerView.setAdapter(adapter);
    }
}
