package com.nanoboost.nanopay;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;



public class HomeNavigationActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, InboxFragment.OnFragmentInteractionListener, AccountFragment.OnFragmentInteractionListener, ProductDetailsFragment.OnFragmentInteractionListener {
    private boolean isSeller = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    ((HomeFragment) selectedFragment).isSeller = isSeller;
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = new InboxFragment();
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = new AccountFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        //Set default fragment
        if (savedInstanceState == null) {
            HomeFragment homeFragment = new HomeFragment();
            isSeller = getIntent().getBooleanExtra("isSeller", false);
            homeFragment.isSeller = isSeller;
            Fragment initialFragment;
            if (isSeller) {
                initialFragment = homeFragment;
            } else {
                initialFragment = new ProductDetailsFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    initialFragment).commit();
        }
        
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
