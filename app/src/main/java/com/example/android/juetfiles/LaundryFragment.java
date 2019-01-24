package com.example.android.juetfiles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class LaundryFragment extends Fragment {

    Switch shirt, pant, tshirt, jeans, bermuda, lower, towel;
    Button Btn;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public LaundryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");

        View view = inflater.inflate(R.layout.fragment_laundry, container, false);


        final EditText shirtdet = view.findViewById(R.id.noOfShirt);
        final EditText pantdet = view.findViewById(R.id.noOfPant);
        final EditText tshirtdet = view.findViewById(R.id.noOfTshirt);
        final EditText jeansdet = view.findViewById(R.id.noOfJeans);
        final EditText bermudadet = view.findViewById(R.id.noOfBernuda);
        final EditText lowerdet = view.findViewById(R.id.noOfLower);
        final EditText toweldet = view.findViewById(R.id.noOfTowel);


        Btn = (Button) view.findViewById(R.id.washBtn);


        shirt = (Switch) view.findViewById(R.id.shirtSwitch);
        pant = (Switch) view.findViewById(R.id.pantSwitch);
        tshirt = (Switch) view.findViewById(R.id.tshirtSwitch);
        jeans = (Switch) view.findViewById(R.id.jeansSwitch);
        bermuda = (Switch) view.findViewById(R.id.bermudaSwitch);
        lower = (Switch) view.findViewById(R.id.lowerSwitch);
        towel = (Switch) view.findViewById(R.id.towelSwitch);


        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "Clothes Deposited", Toast.LENGTH_SHORT).show();

                    if(shirt.isChecked()){
                        final String shirtDetail = shirtdet.getText().toString().trim();
                        final String s1="Shirts";
                        Laundry(shirtDetail, s1);

                    }
                    if(pant.isChecked()){
                        final String pantDetail = pantdet.getText().toString().trim();
                        final String s1="Pants";
                        Laundry(pantDetail, s1);

                    }
                    if(tshirt.isChecked()){
                        final String tshirtDetail = tshirtdet.getText().toString().trim();
                        final String s1="T-shirts";
                        Laundry(tshirtDetail, s1);
                    }
                    if(jeans.isChecked()){
                        final String jeansDetail = jeansdet.getText().toString().trim();
                        final String s1="Jeans";
                        Laundry(jeansDetail, s1);

                    }
                    if(bermuda.isChecked()){
                        final String bermudaDetail = bermudadet.getText().toString().trim();
                        final String s1="Bermudas";
                        Laundry(bermudaDetail, s1);

                    }
                    if(lower.isChecked()){
                        final String lowerDetail = lowerdet.getText().toString().trim();
                        final String s1="Lowers";
                        Laundry(lowerDetail, s1);

                    }
                    if(towel.isChecked()){
                        final String towelDetail = toweldet.getText().toString().trim();
                        final String s1="Towels";
                        Laundry(towelDetail, s1);
                    }
            }
        });

        return view;
    }

    private void Laundry(final String s, String s1) {
        String user_id = mAuth.getUid();
        DatabaseReference current_user_db = mDatabase.child(user_id);
        current_user_db.child("Laundry").child(s1).setValue(s);
    }
}
