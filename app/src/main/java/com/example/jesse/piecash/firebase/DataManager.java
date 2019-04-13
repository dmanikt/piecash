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
        /*ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Post post = dataSnapshot.getValue(Post.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Log.w();
            }
        };*/
        final ArrayList<Group> groups = new ArrayList<Group>();
        Query query = mDatabase.orderByChild("").equalTo("Roomate");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    groups.add(snapshot.getValue(Group.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return;
    }
}
