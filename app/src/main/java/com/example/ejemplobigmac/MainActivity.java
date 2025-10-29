package com.example.ejemplobigmac;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNav;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar propia (usa tema NoActionBar que ya tienes)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        bottomNav = findViewById(R.id.bottomNav);

        // Toggle del Drawer
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Drawer items -> tus fragments drawer1/2/3
        navigationView.setNavigationItemSelectedListener(item -> {
            drawerLayout.closeDrawers();
            switch (item.getItemId()) {
                case R.id.nav_drawer1:
                    showFragment(new drawer1());
                    break;
                case R.id.nav_drawer2:
                    showFragment(new drawer2());
                    break;
                case R.id.nav_drawer3:
                    showFragment(new drawer3());
                    break;
            }
            return true;
        });

        // BottomNav -> tus fragments fragmento_bajo1/2/3
        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bot_1:
                    showFragment(new fragmento_bajo1());
                    break;
                case R.id.bot_2:
                    showFragment(new fragmento_bajo2());
                    break;
                case R.id.bot_3:
                    showFragment(new fragmento_bajo3());
                    break;
            }
            return true;
        });

        // Primer fragment al arrancar
        if (savedInstanceState == null) {
            showFragment(new drawer1());
        }
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    // Menú de opciones en la Toolbar (ya tienes menu_options)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle != null && toggle.onOptionsItemSelected(item)) return true;

        switch (item.getItemId()) {
            case R.id.op_1:
                showFragment(new options1Fragment());
                return true;
            case R.id.op_2:
                showFragment(new options2Fragment());
                return true;
            case R.id.op_3:
                showFragment(new options3Fragment());
                return true;
            case R.id.op_tabs:
                showFragment(new TabbedFragment()); // ViewPager2 + TabLayout
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}
