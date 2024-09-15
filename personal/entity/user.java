package com.personal.entity;


import java.util.ArrayList;
import java.util.List;

public class user {


    private   String userName ;
    private   int type;
    private   double  balance;
    private   String password;


    List<car> collections = new ArrayList<>();
    List<car> contracts = new ArrayList<>();
    
    public user(String userName, String password, double balance, int type) {
        this.userName=userName;
        this.password=password;
        this.balance=balance;
        this.type=type;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance(){
        return balance;
    }
    public void setMoney(double money) {
        this.balance = money;
    }

    public int getPower() {
        return type;
    }
    public void setPower(int power) {
        this.type= power;
    }

    public List<car> getCollections() {
        return collections;
    }
    public void setCollections(List<car> collections) {
        this.collections = collections;
    }
    public List<car> getContracts() {
        return contracts;
    }
    public void setContracts(List<car> contracts) {
        this.contracts = contracts;
    }
    
    public String toString() {
        return "User{"+
               "userName='"+userName+"'"+
               ",password='"+password+"'"+
               ",money="+balance+
               ",power="+type+"}";
    }
}
