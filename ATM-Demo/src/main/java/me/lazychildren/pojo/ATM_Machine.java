package me.lazychildren.pojo;

import lombok.Data;

@Data
public class ATM_Machine {
    private int amount;
    private ATM_Machine(){
        amount = 1000;
    }

    public static ATM_Machine getInstance(){
        if(instance == null)
        {
            instance = new ATM_Machine();

        }
        return instance;
    }


    private static ATM_Machine instance;


    public boolean addAmount(int num){
        amount += num;
        return true;
    }


    public boolean takeAmount(int num){
        if(num > amount)
            return false;
        amount -= num;
        return true;
    }
}
