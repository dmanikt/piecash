package com.example.jesse.piecash.View;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.example.jesse.piecash.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


    }

    protected void main() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_View);

        // Menu Initialization
        Menu menu = navigationView.getMenu();
    }

}
