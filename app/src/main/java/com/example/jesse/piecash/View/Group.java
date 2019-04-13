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


    public void rebalance(Person person){
        int num = members.get(person);
        int temp;
        for(int i=0;i< members.size(); i++ ){
            if(i != num) {
                if (debt[num][i] > debt[i][num]) {
                    temp = debt[i][num];
                    debt[num][i] -= temp;
                    debt[i][num] = 0;
                    debt[num][num] -= temp;
                } else {
                    temp = debt[num][i];
                    debt[i][num] -= temp;
                    debt[num][i] = 0;
                    debt[num][num] -= temp;
                }
            }
        }

    }

    /*
     */
    public void buyForGroup(Person person, int amount){
        int num = members.get(person);
        int total = amount/members.size();
       for(int i = 0; i<members.size();i++){
           if (i != num) {
               debt[i][i] += total;
               debt[i][num] += total;
           }
       }
    }

    public int individualDebt(Person person){
        int num = members.get(person);
        return debt[num][num];
    }

    public boolean containsPerson(Person person){
        return members.containsKey(person);
    }
}