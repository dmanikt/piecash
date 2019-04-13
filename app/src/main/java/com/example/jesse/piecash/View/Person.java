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
       groupName.buyForGroup(this, amount);
       groupName.rebalance(this);
    }

    /*
    *Checks to see if a group is in the persons list of active groups
     */
    public boolean inGroup(Group groupName){
        return groups.contains(groupName);
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
