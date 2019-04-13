package com.example.jesse.piecash.View;

import java.util.HashMap;

public class Group {
    private String name;
    private HashMap<Person, Integer> members;

    public Group(String name, Person person){
        this.name = name;
        members = new HashMap<>();
        members.put(person, 0);
    }

    public void addMember(Person person){
        members.put(person, 0);
    }

    private void rebalance(Person person, int amount){

    }

    private

}
