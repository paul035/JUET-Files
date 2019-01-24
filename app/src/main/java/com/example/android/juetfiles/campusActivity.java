package com.example.android.juetfiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

public class campusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<itemActivity> mlist = new ArrayList<>();
        mlist.add(new itemActivity(R.drawable.main_gate, "Main Entry Gate"));
        mlist.add(new itemActivity(R.drawable.over_view, "Campus Overview"));
        mlist.add(new itemActivity(R.drawable.lake_0, "Lake"));
        mlist.add(new itemActivity(R.drawable.lecture_hall, "Lecture Theatre"));
        mlist.add(new itemActivity(R.drawable.library, "Library"));
        mlist.add(new itemActivity(R.drawable.library_1, "Library"));
        mlist.add(new itemActivity(R.drawable.lake_1, "Lake"));
        mlist.add(new itemActivity(R.drawable.badminton, "Badminton Court"));


        Adapter adapter = new Adapter(this, mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
