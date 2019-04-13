package com.example.jesse.piecash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateGroupActivity extends AppCompatActivity {
    private Button addPersonButton = findViewById(R.id.addPersonButton);
    private Button doneButton = findViewById(R.id.doneButton);
    private Button backButton = findViewById(R.id.backButton);
    EditText groupNameField = (EditText) findViewById(R.id.groupNameField);
    EditText personName = findViewById(R.id.personName);
    ArrayList<String> namesList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        addPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!personName.getText().toString().equals("") || !personName.getText().toString().equals(null)) {
                    namesList.add(personName.getText().toString());
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (CreateGroupActivity.this, MainActivity.class);
                setIntent(intent);
            }
        });
    }


}
