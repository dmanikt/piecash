package com.example.jesse.piecash.View;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toolbar;

import com.example.jesse.piecash.R;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ArrayList<String> list = new ArrayList<String>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);*/
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    protected void main() {

    }


}
