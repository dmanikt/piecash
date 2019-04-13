package com.example.jesse.piecash.View;

import java.util.ArrayList;

public class Person {
    private String firstName;
    private String lastName;
    private int id;

    private int bankAccount;

    private double totalDebt;

    private ArrayList<Group> groups;


    public Person(String firstName, String lastName, int id, int bankAccount){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.bankAccount = bankAccount;
        groups = new ArrayList<>();

    }


    public void buy(int amount, Group groupName){
        groupName.rebalance(this, amount);
    }

    public boolean inGroup(Group groupName){
        return groups.contains(groupName);
    }

    public void createGroup(Sting name, Person other){
        Group newGroup =new Group(name, this);
        groups.add(newGroup);
        newGroup.addMember(other);
        other.addGroup(newGroup);
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int retrieveDept(Group groupName){
       return groupName.inDividualDebt(this);
    }
}
