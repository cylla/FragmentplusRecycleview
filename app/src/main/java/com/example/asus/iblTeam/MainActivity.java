package com.example.asus.iblTeam;

        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.design.widget.BottomNavigationView;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.view.MenuItem;

        import com.example.asus.iblTeam.HomeFragment;
        import com.example.asus.iblTeam.ProfileFragment;
        import com.example.asus.iblTeam.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView buttonNavigationView;
    Fragment selectedFragment = new HomeFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNavigationView = findViewById(R.id.btnnav);
        buttonNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                selectedFragment = new HomeFragment();

                break;
            case R.id.menu_profile:
                selectedFragment = new ProfileFragment();

                break;
        }

        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_container, selectedFragment)
                    .commit();

            return true;
        }
        return false;
    }
}
