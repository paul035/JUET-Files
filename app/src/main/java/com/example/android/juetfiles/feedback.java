package com.example.android.juetfiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hsalf.smilerating.SmileRating;

public class feedback extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private EditText feedBackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        feedBackText = (EditText) findViewById(R.id.feedbackView);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");

        SmileRating smileRating = (SmileRating) findViewById(R.id.smile_rating);

        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley) {
                    case SmileRating.BAD:
                        Toast.makeText(feedback.this, "BAD", Toast.LENGTH_SHORT).show();
                        String s0 = feedBackText.getText().toString().trim();
                        FeedbackPrint("BAD", s0);
                        break;
                    case SmileRating.GOOD:
                        Toast.makeText(feedback.this, "GOOD", Toast.LENGTH_SHORT).show();
                        String s1 = feedBackText.getText().toString().trim();
                        FeedbackPrint("Good", s1);
                        break;
                    case SmileRating.GREAT:
                        Toast.makeText(feedback.this, "GREAT", Toast.LENGTH_SHORT).show();
                        String s2 = feedBackText.getText().toString().trim();
                        FeedbackPrint("GREAT", s2);
                        break;
                    case SmileRating.OKAY:
                        Toast.makeText(feedback.this, "OKAY", Toast.LENGTH_SHORT).show();
                        String s3 = feedBackText.getText().toString().trim();
                        FeedbackPrint("OKAY", s3);
                        break;
                    case SmileRating.TERRIBLE:
                        Toast.makeText(feedback.this, "TERRIBLE", Toast.LENGTH_SHORT).show();
                        String s4 = feedBackText.getText().toString().trim();
                        FeedbackPrint("TERRIBLE", s4);
                        break;
                }

            }
        });


    }

    private void FeedbackPrint(String feedback, String detail) {
        String user_id = mAuth.getUid();
        DatabaseReference current_user_db = mDatabase.child(user_id);
        current_user_db.child("Feedback").setValue(feedback);
        current_user_db.child("Review").setValue(detail);
    }
}
