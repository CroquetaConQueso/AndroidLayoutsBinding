package com.example.ejemplobigmac;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ejemplobigmac.databinding.ActivityMenuBajoBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityMenuBajo extends AppCompatActivity {

    private ActivityMenuBajoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMenuBajoBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        NavHostFragment host = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = host.getNavController();

        AppBarConfiguration appBarConfig = new AppBarConfiguration.Builder(
                R.id.fragmento_bajo1, R.id.fragmento_bajo2, R.id.fragmento_bajo3
        ).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);

        BottomNavigationView bottom = binding.bottomNavView;
        NavigationUI.setupWithNavController(bottom, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavHostFragment host = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        return host.getNavController().navigateUp() || super.onSupportNavigateUp();
    }
}
