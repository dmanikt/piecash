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

    public void rebalance(Person person, int amount){
        int currentDebtOfBuyer = members.get(person);
        int updatedDebtOfBuyer = currentDebtOfBuyer - amount;
        double updateAmountOfOthers = (double)amount/(double)(members.size() - 1);
        members.put(person, updatedDebtOfBuyer);
        double otherPersonDebt;

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
}