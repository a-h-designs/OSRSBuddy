package com.ahdesigns.osrsbuddy;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class statsDetailScreen extends AppCompatActivity {

    TextView user;

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statsdetailscreen);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        username = extras.getString("username");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Old School Hiscores");

        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        user = findViewById(R.id.user);
        user.setText(username);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter  adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new hiscoreFragment(), "Hiscores");
        adapter.addFragment(new activityFragment(), "Activities");
        viewPager.setAdapter(adapter);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void onBackPressed() {
    }
}