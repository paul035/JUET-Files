package com.example.android.juetfiles;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText mLoginNameField;
    private EditText mLoginPasswordField;
    private Button mLoginBtn;
    private Button reg_button, learn_more;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private SharedPreferences sharedPreferences;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("sp", Context.MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();

        mLoginNameField = (EditText) findViewById(R.id.loginNameField);
        mLoginPasswordField = (EditText) findViewById(R.id.loginPasswordField);

        mLoginBtn = (Button) findViewById(R.id.loginBtn);
        if(sharedPreferences.getBoolean("isLoggedIn", false)){
            Log.w(TAG, "onCreate: "+"sp: true");
            startActivity(new Intent(MainActivity.this, AccountActivity.class));
            finish();
        }
        Log.w(TAG, "onCreate: "+"sp: true");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn",true);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, AccountActivity.class));
                    finish();
                }
            }
        };


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Log in...", Toast.LENGTH_SHORT).show();
                startSignIn();
            }
        });

        reg_button = (Button) findViewById(R.id.jointheclub_button);
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUpActivity();
            }
        });

        learn_more = (Button) findViewById(R.id.learnmore_button);
        learn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLearnMoreActivity();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSignIn() {
        String email = mLoginNameField.getText().toString().trim();
        String password = mLoginPasswordField.getText().toString().trim();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_LONG).show();
        }
        else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Sign in problem", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    public void openSignUpActivity() {
        Log.w(TAG, "openSignUpActivity: "+"called");
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    public void openLearnMoreActivity() {
        Log.w(TAG, "openLearnMoreActivity: "+"called");
        Intent intent = new Intent(this, LearnMoreActivity.class);
        startActivity(intent);
        finish();
    }
}
