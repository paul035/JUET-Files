package com.example.android.juetfiles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class LearnMoreActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView campuscard, placementcard, departmentcard, jyccard, contactcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);
        //defining cards
        campuscard = (CardView) findViewById(R.id.campus_card);
        placementcard = (CardView) findViewById(R.id.placement_card);
        departmentcard = (CardView) findViewById(R.id.department_card);
        jyccard = (CardView) findViewById(R.id.jyc_card);
        contactcard = (CardView) findViewById(R.id.contact_card);
        //add listener
        campuscard.setOnClickListener(this);
        placementcard.setOnClickListener(this);
        departmentcard.setOnClickListener(this);
        jyccard.setOnClickListener(this);
        contactcard.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Intent i;
        switch (v.getId()){
            case R.id.campus_card : i = new Intent(this, campusActivity.class); startActivity(i); break;
            case R.id.placement_card : i = new Intent(this, placementActivity.class); startActivity(i); break;
            case R.id.department_card : i = new Intent(this, departmentActivity.class); startActivity(i); break;
            case R.id.jyc_card : i = new Intent(this, jycActivity.class); startActivity(i); break;
            case R.id.contact_card : i = new Intent(this, contactActivity.class); startActivity(i); break;
            default:break;
        }

    }
}
