package com.example.demo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager pager;
    TabLayout mTabloyout;
    TabItem first_item, second_item, third_item, fourth_item;
    PagerAdaptor pagerAdaptor;


    private BottomNavigationView main_nav;
    private FrameLayout main_frame;
    private Home homefragment;
    private alert alertfragment;
    private notification notificationfragment;
    private AddLocation addLocationfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        first_item = findViewById(R.id.first_item);
        second_item = findViewById(R.id.second_item);
        third_item = findViewById(R.id.third_item);
        fourth_item = findViewById(R.id.fourth_item);

        pager = findViewById(R.id.pager);
        mTabloyout = findViewById(R.id.tabLayout);


        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        //frames

        main_frame = (FrameLayout) findViewById(R.id.main_frame);
        main_nav = (BottomNavigationView) findViewById(R.id.main_nav);
        homefragment = new Home();
        alertfragment = new alert();
        notificationfragment = new notification();
        addLocationfragment = new AddLocation();


        main_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.navhome:
                        setFragment(homefragment);
                        return true;
                    case R.id.nav_alert:
                        setFragment(alertfragment);
                        return true;
                    case R.id.nav_notifi:
                        setFragment(notificationfragment);
                        return true;
                    case R.id.nav_addlocation:
                        setFragment(addLocationfragment);
                        return true;
                    default:
                        return false;
                }


            }

            private void setFragment(Fragment fragment) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, fragment);
                fragmentTransaction.commit();
            }

        });


        //tabs
        pagerAdaptor = new PagerAdaptor(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mTabloyout.getTabCount());

        pager.setAdapter(pagerAdaptor);


        mTabloyout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabloyout));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.search,menu);

        return true;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // drawerLayout.closeDrawer(GravityCompat.START);
        //if(item.getItemId()==R.id.first_item){
        //   Toast.makeText(this,"my profile",Toast.LENGTH_LONG).show();
        //}
        //return false;
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.first_item:
                Toast.makeText(this, "my profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second_item:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third_item:
                Toast.makeText(this, "help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fourth_item:
                Toast.makeText(this, "logout successfull", Toast.LENGTH_SHORT).show();
                break;

            default:
                return false;


        }
        return false;


    }
}

