package com.rafiansyahdesign.calsanicchatbot;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.io.*;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

    }
    frgHome firstFragment = new frgHome();
    frgChatbot secondFragment = new frgChatbot();
    frgMbti thirdFragment = new frgMbti();
    frgSettings fourthFragment = new frgSettings();
    frgAccount fifthFragment = new frgAccount();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
                return true;

            case R.id.chatbot:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commit();
                return true;

            case R.id.mbti:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
                return true;

            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fourthFragment).commit();
                return true;

            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, fifthFragment).commit();
                return true;
        }
        return false;
    }
}
