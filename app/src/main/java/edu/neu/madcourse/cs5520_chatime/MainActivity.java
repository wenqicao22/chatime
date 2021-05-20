package edu.neu.madcourse.cs5520_chatime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import edu.neu.madcourse.cs5520_chatime.Adapters.ViewPagerAdapter;
import edu.neu.madcourse.cs5520_chatime.Fragments.BottlesFragment;
import edu.neu.madcourse.cs5520_chatime.Fragments.HomeFragment;
import edu.neu.madcourse.cs5520_chatime.Fragments.MessagesFragment;

public class MainActivity extends AppCompatActivity {
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login_page);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent im = new Intent(v.getContext(), LoginActivity.class);
                startActivity(im);
            }
        });

        // initial tab layout and view pager
        TabLayout tabLayout = findViewById(R.id.bottom_tab_layout);
        ViewPager viewPager = findViewById(R.id.bottom_view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //add fragments
        viewPagerAdapter.addFrag(new MessagesFragment(), "Messages");
        viewPagerAdapter.addFrag(new HomeFragment(), "Home");
        viewPagerAdapter.addFrag(new BottlesFragment(), "Bottles");

        //set view pager adapter
        viewPager.setAdapter(viewPagerAdapter);

        //set view pager for tab layout
        tabLayout.setupWithViewPager(viewPager);

        //set icon for fragments
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_chat2);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_bottle3);

    }
    //create an action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //handle action bar button activities
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.user_button:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}