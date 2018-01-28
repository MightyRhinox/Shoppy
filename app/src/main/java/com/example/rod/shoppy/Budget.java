package com.example.rod.shoppy;

/**
 * Created by rod on 28/01/18.
 */

public class Budget {

    private double startingbudget;
    private double remainingbudget;
    private double usedbudget;

    public Budget() {
        this.startingbudget = 0;
        this.remainingbudget = 0;
        this.usedbudget = 0;
    }

    public void updateBudget(double price){

        this.remainingbudget -= price;
        this.usedbudget += price;

    }

    public double getStartingbudget() {
        return startingbudget;
    }

    public void setStartingbudget(double startingbudget) {
        this.startingbudget = startingbudget;
        if (this.usedbudget == 0){
            this.remainingbudget = this.startingbudget;
        }else{
            this.remainingbudget = this.startingbudget - this.usedbudget;
        }
    }

    public double getRemainingbudget() {
        return remainingbudget;
    }

    public double getUsedbudget() {
        return usedbudget;
    }

}
