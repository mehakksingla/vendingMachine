/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.vendingMachine.dto;

import java.math.BigDecimal;

/**
 * @author Mehak Singla
 */
public class Change {

    private enum Coins{
        QUARTER (new BigDecimal("0.25")),
        DIME (new BigDecimal("0.10")),
        NICKEL (new BigDecimal("0.05")),
        PENNY (new BigDecimal ("0.01"));
        
        public final BigDecimal value;
        
        private Coins(BigDecimal value){
            this.value = value;
        }
    }
        
    private int numOfQuarters, numOfDimes, numOfNickels, numOfPennies;
    private final BigDecimal amount;

    public Change(BigDecimal change) {
        this.amount = change;
        calculateCoins();
    }
        
    private void calculateCoins() {
        final int numOfCoinsIndex = 0;
        final int remainderIndex = 1;
    
    //divideAndRemainders returns BigDecimal array with integer 
    //value of division in index 0 and remainder value in index 1    
        
    BigDecimal[] quarters = amount.divideAndRemainder(Coins.QUARTER.value);
    BigDecimal[] dimes = quarters[remainderIndex].divideAndRemainder(Coins.DIME.value);
    BigDecimal[] nickels = dimes[remainderIndex].divideAndRemainder(Coins.NICKEL.value);
    BigDecimal[] pennies = nickels[remainderIndex].divideAndRemainder(Coins.PENNY.value);

    this.numOfQuarters = quarters[numOfCoinsIndex].intValue();
    this.numOfDimes = dimes[numOfCoinsIndex].intValue();
    this.numOfNickels = nickels[numOfCoinsIndex].intValue();
    this.numOfPennies = pennies[numOfCoinsIndex].intValue();
    
    }

    public int getNumOfQuarters() {
        return numOfQuarters;
    }

    public void setNumOfQuarters(int numOfQuarters) {
        this.numOfQuarters = numOfQuarters;
    }

    public int getNumOfDimes() {
        return numOfDimes;
    }

    public void setNumOfDimes(int numOfDimes) {
        this.numOfDimes = numOfDimes;
    }

    public int getNumOfNickels() {
        return numOfNickels;
    }

    public void setNumOfNickels(int numOfNickels) {
        this.numOfNickels = numOfNickels;
    }

    public int getNumOfPennies() {
        return numOfPennies;
    }

    public void setNumOfPennies(int numOfPennies) {
        this.numOfPennies = numOfPennies;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "\n Change = " + amount + " {" + "numOfQuarters = " + numOfQuarters + 
                            ", numOfDimes = " + numOfDimes + 
                            ", numOfNickels = " + numOfNickels + 
                            ", numOfPennies = " + numOfPennies + '}' ;
        
    }
    
    
}
    


    