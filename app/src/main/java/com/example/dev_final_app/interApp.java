package com.example.dev_final_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.dev_final_app.FragmentsMenu.CardsFragment;
import com.example.dev_final_app.FragmentsMenu.FeedFragment;
import com.example.dev_final_app.FragmentsMenu.FragmentChat;
import com.example.dev_final_app.FragmentsMenu.PerfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class interApp extends AppCompatActivity {

    private Toolbar toolbarApp;

    private BottomNavigationView menuInferior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_app);

        toolbarApp = findViewById(R.id.toolbarA);

        menuInferior = findViewById(R.id.menuInferior);

        setSupportActionBar(toolbarApp);

        getSupportFragmentManager().beginTransaction().add(R.id.frame1, new FeedFragment()).commit();

        menuInferior.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int fragmentSelect = item.getItemId();

                if(fragmentSelect == R.id.menuFeed ){

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new FeedFragment()).commit();
                    return true;
                }else if(fragmentSelect == R.id.menuPlay ){

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new CardsFragment()).commit();
                    return true;
                }else if(fragmentSelect == R.id.menuChat ){

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new FragmentChat()).commit();
                    return true;
                }else if(fragmentSelect == R.id.menuPerfil ){

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new PerfilFragment()).commit();
                    return true;
                }

                return false;
            }
        });







    }
}


