package com.example.android.juetfiles;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.CardView;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class RoomMaintenanceFragment extends   Fragment implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;


    public RoomMaintenanceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");

        View view= inflater.inflate(R.layout.fragment_room_maintenance, container, false);


        CardView couchView = (CardView) view.findViewById(R.id.couch_card);
        CardView deskView = (CardView) view.findViewById(R.id.desk_card);
        CardView wardrobeView = (CardView) view.findViewById(R.id.wardrobe_card);
        CardView doorView = (CardView) view.findViewById(R.id.door_card);
        CardView fanView = (CardView) view.findViewById(R.id.fan_card);
        CardView lightbulbView = (CardView) view.findViewById(R.id.light_bulb_card);

        couchView.setOnClickListener(this);
        deskView.setOnClickListener(this);
        wardrobeView.setOnClickListener(this);
        doorView.setOnClickListener(this);
        fanView.setOnClickListener(this);
        lightbulbView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "Issue Submitted", Toast.LENGTH_SHORT).show();
        if(view.getId() == R.id.couch_card){
            String user_id = mAuth.getCurrentUser().getUid();
            DatabaseReference current_user_db = mDatabase.child(user_id);
            current_user_db.child("Room Maintenance").child("COUCH").setValue("Bed Problem");
        }
        else if(view.getId() == R.id.desk_card){
            String user_id = mAuth.getCurrentUser().getUid();
            DatabaseReference current_user_db = mDatabase.child(user_id);
            current_user_db.child("Room Maintenance").child("SEAT | DESK").setValue("Table or Chair issue");
        }
        else if(view.getId() == R.id.wardrobe_card){
            String user_id = mAuth.getCurrentUser().getUid();
            DatabaseReference current_user_db = mDatabase.child(user_id);
            current_user_db.child("Room Maintenance").child("WARDROBE").setValue("ALMIRA PROBLEM");
        }
        else if(view.getId() == R.id.door_card){
            String user_id = mAuth.getCurrentUser().getUid();
            DatabaseReference current_user_db = mDatabase.child(user_id);
            current_user_db.child("Room Maintenance").child("DOOR | WINDOWS").setValue("Door or Window pane issues");
        }
        else if(view.getId() == R.id.fan_card){
            String user_id = mAuth.getCurrentUser().getUid();
            DatabaseReference current_user_db = mDatabase.child(user_id);
            current_user_db.child("Room Maintenance").child("VENTILATOR").setValue("Fan or Regulator problem");
        }
        else {
            String user_id = mAuth.getCurrentUser().getUid();
            DatabaseReference current_user_db = mDatabase.child(user_id);
            current_user_db.child("Room Maintenance").child("LIGHT BULB | SWITCH BOARD").setValue("Bulb or Switch board problem");
        }
    }
}
