package com.example.jesse.piecash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jesse.piecash.View.Group;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class CreateGroupActivity extends AppCompatActivity {
    private Button addPersonButton;
    private Button doneButton;
    private Button backButton;
    EditText groupNameField;
    EditText personName;
    ArrayList<String> namesList;
    ArrayList<Group> groups;
    ListView listView;
    ArrayAdapter <String>
            adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        addPersonButton = findViewById(R.id.addPersonButton);
        doneButton = findViewById(R.id.doneButton);
        backButton = findViewById(R.id.backButton);
        groupNameField = (EditText) findViewById(R.id.groupNameField);
        personName = findViewById(R.id.personName);
        namesList = new ArrayList<String>();
        groups = new ArrayList<>();
        listView = findViewById(R.id.listView);
        adp = new ArrayAdapter(CreateGroupActivity.this, android.R.layout.simple_list_item_1, namesList);
        listView.setAdapter(adp);
        addPersonButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!personName.getText().toString().equals("") || !personName.getText().toString().equals(null)) {
                    namesList.add(personName.getText().toString());
                    adp.notifyDataSetChanged();
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
                activity.setGroup(groups);

                Intent intent = new Intent(CreateGroupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
