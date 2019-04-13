package com.example.jesse.piecash.View;

import java.util.ArrayList;
/*
*A Person class represents an account with our app. A person has access to all the seperate groups
* they are in. A person can update debts when they buy something for a group.
*
*
*/
public class Person {
    private String firstName;
    private String lastName;
    private int id;

    private int bankAccount;

    private double totalDebt;

    private ArrayList<Group> groups;

/*
*Standard constructor
 */
    public Person(String firstName, String lastName, int id, int bankAccount){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.totalDebt = 0;
        this.bankAccount = bankAccount;
        groups = new ArrayList<>();

    }

/*
*Buy will allow the person to lower their debt within a group
 */
    public void buy(int amount, Group groupName){
        /*
        1) if the person had positive debt, and they pay less than or equal to their debt */
        if (groupName.individualDebt(this) > 0 && amount <= groupName.individualDebt(this)) {
            groupName.payOffDebts(this, amount);
        }
        /*
        2) if the person had positive debt, and they pay more than their debt */
        else if (groupName.individualDebt(this) > 0 && amount > groupName.individualDebt(this)){
            int debt = groupName.individualDebt(this);
            groupName.payOffDebts(this, debt); /* zeros out their debt */
            int temp = amount - debt;
            groupName.buyForGroup(this, temp); /* sends the rest to split amongst group members */
        }
        /*
        3) if the person has no debt, and they pay any amount */
        else{
            groupName.buyForGroup(this, amount);
        }

    }

    /*
    *Checks to see if a group is in the persons list of active groups
     */
    public boolean inGroup(Group groupName){
        return groups.contains(groupName);
    }

    /*
    *Creates a new group between the creator and one other person.
     */
    public void createGroup(String name, Person other){
        Group newGroup =new Group(name,this);
        groups.add(newGroup);
        newGroup.addMember(other);
        other.addGroup(newGroup);
    }

    /*
    *adds a new person to an existing group. Does nothing if the group does not exist in the current
    * list of groups.
     */
    public void addPersonToExistingGroup(Group group, Person other){
        if(groups.contains(group)){
            groups.get(groups.indexOf(group)).addMember(other);
        }
    }

    /*
    * updates the group list if the current person is within the group
     */
    public void addGroup(Group group){
        if(group.containsPerson(this)) {
            groups.add(group);
        }
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

/*
*totals the debt from every group the person is in and returns the value;
 */
    public double getTotalDebt(){
        for(Group g: this.groups){
            if(g.individualDebt(this) > 0){
                totalDebt+= g.individualDebt(this);
            }
        }
        return totalDebt;
    }
}
