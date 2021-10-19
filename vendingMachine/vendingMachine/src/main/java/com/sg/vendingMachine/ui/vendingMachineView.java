/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.vendingMachine.ui;

import com.sg.vendingMachine.dto.Change;
import com.sg.vendingMachine.dto.Item;
import com.sg.vendingMachine.serviceLayer.InvalidInputException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author Mehak Singla
 */
public class vendingMachineView {
    
    
    private UserIO io;
    private static final int MONEY_SCALE = 2;

    public vendingMachineView(UserIO io) {
        this.io = io;
    }

    public int getMainMenuChoice() {
        io.println("\n=====PLEASE CHOOSE ONE OPTION=====");
        io.println("1. Make a purchase");
        io.println("2. Exit");
        return io.readInt("Select one option: ", 1,2);
    }
    
    public BigDecimal inputMoney() throws InvalidInputException {
        try{
            return new BigDecimal(io.readString("Insert Money: ")).setScale(MONEY_SCALE, RoundingMode.HALF_UP);
        }
        catch(NumberFormatException e){
            throw new InvalidInputException("That is not a valid numerical value");
        }
    }
    
    public void displayErrorMessage(String message) {
        io.println(message);
    }
    
    public void displayItemMenuChoices(List<Item> allItems) {
        String itemString, itemHeader;
        itemHeader = String.format("%-15s%-20s%-10s%-10s\n", "Option", "Item Name", "Price", "Stock");
        //Format a string with the specified number of characters and also left justify.
        io.println("=====VENDING OPTIONS======\n");
        io.println(itemHeader);
        for(Item item : allItems) {
            itemString = String.format("%-15s%-20s$%-10s%-10s\n", item.getMenuKey(), item.getName(), item.getPrice(), item.getStock());
            io.print(itemString);
        }
    }
    
    public String getItemMenuChoice() {
        return io.readString("Select an item from the vending options:");
    }
    
    public void displayChange(Change change) {
        io.println(change.toString());
        
    }
    
    public void displayVended() {
        io.println("\n PLEASE COLLECT YOUR ITEM FROM THE MACHINE.");
    }
    
    public void displayRefund(Change change) {
        io.println("$ " + change.getAmount() + " has been refunded to you.");
    }
}
