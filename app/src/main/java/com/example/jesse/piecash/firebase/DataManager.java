package com.example.jesse.piecash.firebase;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.jesse.piecash.View.Group;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DataManager {
    private DatabaseReference mDatabase;
    public DataManager() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //mDatabase.setValue("hello");
    }

    public void addGroup(String group) {
        //mDatabase.push().setValue(group);
    }

    public void getGroups() {
        final ArrayList<String> groups = new ArrayList<>();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.child("Roommates").child("Dhruv").getChildren()) {
                    System.out.println("Count " + snapshot.getChildrenCount());
                    Post post = snapshot.getValue(Post.class);
                    System.out.println("VALUE: " + post.uid + " " + post.author + " " + post.title + " " + post.body);
                    //groups = post.title;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("CANCELED");
            }
        });
    }
}
