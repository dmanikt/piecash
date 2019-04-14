package com.example.jesse.piecash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jesse.piecash.View.Group;

import java.util.ArrayList;

public class CreateGroupActivity extends AppCompatActivity {
    private Button addPersonButton;
    private Button doneButton;
    private Button backButton;
    EditText groupNameField;
    EditText personName;
    ArrayList<String> namesList = new ArrayList<String>();
    ArrayList<Group> groups = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        addPersonButton = findViewById(R.id.addPersonButton);
        doneButton = findViewById(R.id.doneButton);
        backButton = findViewById(R.id.backButton);
        groupNameField = (EditText) findViewById(R.id.groupNameField);
        personName = findViewById(R.id.personName);

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

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = new MainActivity();
               // Group newGroup = new Group();
                activity.setGroup(groups);

                Intent intent = new Intent(CreateGroupActivity.this, activity.getClass());
                setIntent(intent);
            }
        });
    }


}
