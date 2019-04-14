package com.example.jesse.piecash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ArrayList <String> list;
    ListView listView;
    ArrayAdapter adp;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView = findViewById(R.id.listView);
        backButton = findViewById(R.id.backButton);
        adp = new ArrayAdapter(HistoryActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adp);
        list = new ArrayList<>();
        list.add(" $25   Date: 2/14/19");
        list.add(" $30   Date: 2/7/19");
        list.add("-$15   Date: 2/3/19");
        list.add(" $20   Date: 1/25/19");
        list.add(" $17   Date: 1/20/19");
        list.add("-$13   Date: 1/13/19");
        list.add(" $10   Date: 1/4/19");
        adp.notifyDataSetChanged();
        backButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HistoryActivity.this, MainActivity.class);
                setIntent(intent);
            }
        });
    }


}
