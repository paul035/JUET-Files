package com.example.android.juetfiles;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class AccountActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    android.support.v7.widget.Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;

    TabItem tabRoomMaintenance;
    TabItem tabLaudry;
    TabItem tabLendAndBorrow;
    TabItem tabNoticeBoard;
    TabItem tabGeneralReport;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(AccountActivity.this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(AccountActivity.this);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);

        tabRoomMaintenance = findViewById(R.id.tabRoomMaintenance);
        tabLaudry = findViewById(R.id.tabLaundry);
        tabLendAndBorrow = findViewById(R.id.tabLendAndBorrow);
        tabNoticeBoard = findViewById(R.id.tabNoticeBoard);
        tabGeneralReport = findViewById(R.id.tabGeneralReport);


        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.roomsservice));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.roomsservice));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(AccountActivity.this, R.color.roomsservice));
                    }
                }
                if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.laundry));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.laundry));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(AccountActivity.this, R.color.laundry));
                    }
                }
                if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.lendandborrow));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.lendandborrow));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(AccountActivity.this, R.color.lendandborrow));
                    }
                }
                if (tab.getPosition() == 3) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.noticeboard));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.noticeboard));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(AccountActivity.this, R.color.noticeboard));
                    }
                }
                if (tab.getPosition() == 4) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.generalreport));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(AccountActivity.this, R.color.generalreport));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(AccountActivity.this, R.color.generalreport));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    Intent loginIntent = new Intent(AccountActivity.this, MainActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);
                }
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.action_logout) {
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.room) {
            RoomMaintenanceFragment roomMaintenanceFragment = new RoomMaintenanceFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.drawer, roomMaintenanceFragment).commit();
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        if (id == R.id.action_logout) {
            logout();
        }

        if(id == R.id.feedback){
            Intent intent = new Intent(AccountActivity.this, feedback.class);
            startActivity(intent);
        }

        if(id == R.id.developer){
            Intent intent = new Intent(AccountActivity.this, developer.class);
            startActivity(intent);
        }

        return false;

    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private void logout() {
        mAuth.signOut();
    }
}
