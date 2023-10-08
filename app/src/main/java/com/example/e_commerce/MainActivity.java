package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
   Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer1);
        navigationView=findViewById(R.id.navigationView);
        toolbar=findViewById(R.id.toolbar);



        // Now you can use the retrieved values as needed
        // For example, you can display them in a TextView







        //step 1-first setup toolbar
        setSupportActionBar(toolbar);

        //for toggling side view navigation
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //to load the home fragment
        LoadFragment(new datafragment());

        //for click the side navigation item
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();

                if(id ==R.id.nav_home)
                {
                    LoadFragment(new datafragment());
                    
                }
                else if (id==R.id.nav_person)
                {
                    LoadFragment(new AccountinfoFragment());
                }
                else if (id ==R.id.nav_Cart)
                {
                    Toast.makeText(MainActivity.this, "cart", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    signOut();
                }

                //when user add some item then to close the drawer
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void LoadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);  // Use replace instead of add
        ft.commit();
    }
    private void signOut() {
        // Clear any user session or authentication state

        // Start the LoginActivity
        Intent intent = new Intent(MainActivity.this, loginpage.class);
        startActivity(intent);
        finish(); // Optional: Close the current activity after starting the login activity
    }


}