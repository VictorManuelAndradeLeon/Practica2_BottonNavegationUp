package com.leondechino.bottonNavegation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    NotiFragment notiFragment = new NotiFragment();
    SettFragment settFragment = new SettFragment();
    AboutFragment aboutFragment = new AboutFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navbar = findViewById(R.id.navbar);
        loadFragment(homeFragment);
        navbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuhome:loadFragment(homeFragment);return true;
                    case R.id.menunotifications:loadFragment(notiFragment);return true;
                    case R.id.menusettings:loadFragment(settFragment); return true;
                    case R.id.menuabout:loadFragment(aboutFragment); return true;
                }
                return false;
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, fragment).commit();
    }
}