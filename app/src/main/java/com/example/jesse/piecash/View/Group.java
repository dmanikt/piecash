package com.example.jesse.piecash.View;

import java.util.ArrayList;
import java.util.HashMap;
/*
*Group class that represents a few people that are buying things for each other. Can be roommates that
* Go to the grocery store regularly and buy things for each other. Or just two people that pay for
* each others meals that want to keep track of how much they owe each other.
 */
public class Group {
    private String name;
    private HashMap<Person, Integer> members;
    private int position = 0;
    private int[][] debt;



    /*
    *Standard constructor
     */
    public Group(String name, ArrayList<Person> persons){
        this.name = name;
        members = new HashMap<>();
        for(Person p: persons){
            members.put(p, position++);
            p.addGroup(this);
        }
        debt = new int[persons.size()][persons.size()];
    }


    public void payOffDebts(Person person, int amount){
        int debt = this.debt[];
        if (amount < debt){
            members.put(person, debt - amount);
        }
    }

    /*
    *Will divide the amount paid by the size of the group minus the person. Continues to subtract that
    * value from the persons current debt. If their debt is still positve the function returns. If
    * the persons debt was positive and is now negative will increase the debt of the other people in
    * the group by the negative amount divided by the size of the group minus 1. If the persons debt
    * is strictly negative will increse the other peoples debt by the amount split between the other members.
    *
     */
    public void buyForGroup(Person person, int amount){
        int currentDebtOfBuyer = members.get(person);
        int updatedDebtOfBuyer = currentDebtOfBuyer - (int)((double)amount/(double)(members.size()));
        double updateAmountOfOthers;
        members.put(person, updatedDebtOfBuyer);
        double otherPersonDebt;

        if(updatedDebtOfBuyer >= 0){
            return;
        }
        if(updatedDebtOfBuyer < 0){
            updateAmountOfOthers = (double)Math.abs(updatedDebtOfBuyer)/(double)(members.size());
            members.put(person, 0);
        } else {
            updateAmountOfOthers = (double)amount/(double)(members.size());
        }
        //update everyones debt
        for(Person p: members.keySet()){
            otherPersonDebt = members.get(p);
            if(!p.equals(person)){
                members.put(p, (int)(otherPersonDebt + updateAmountOfOthers));
            }
        }
    }

    public int individualDebt(Person person){
        return members.get(person);
    }

    public boolean containsPerson(Person person){
        return members.containsKey(person);
    }
}