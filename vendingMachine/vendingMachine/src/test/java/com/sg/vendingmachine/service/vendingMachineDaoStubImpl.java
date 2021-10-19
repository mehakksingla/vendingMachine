/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.vendingmachine.service;

import com.sg.vendingMachine.dao.ItemPersistenceException;
import com.sg.vendingMachine.dao.vendingMachineDao;
import com.sg.vendingMachine.dto.Change;
import com.sg.vendingMachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mehak Singla
 */
public class vendingMachineDaoStubImpl implements vendingMachineDao{
    
    public Item item, item2;
    private BigDecimal insertedMoney;
    private HashMap<String, Item> inventory;
    
    public vendingMachineDaoStubImpl(){
        
        item = new Item("A","TestItem1", "3.50", "5");
        item2 = new Item("B","TestItem2", "2.00", "0");
        inventory = new HashMap<>();
        inventory.put(item.getMenuKey(), item);
        inventory.put(item2.getMenuKey(), item2);
    }

    @Override
    public void setInsertedMoney(BigDecimal money) {
        this.insertedMoney = money;
    }

    @Override
    public BigDecimal returnInsertedMoney() {
        BigDecimal bd = this.insertedMoney;
        this.insertedMoney.equals(0);
        return bd;
    }

    @Override
    public Item getItem(String menuKey) {
        return inventory.get(menuKey);
    }

    @Override
    public void vendItem(String choice) {
        this.getItem(choice).vend();
    }

    @Override
    public Change calculateChange(String choice) {
        BigDecimal bd = this.insertedMoney;
        this.insertedMoney.equals(0);       //Set inserted money to zero as change is being returned
        return new Change(bd.subtract(getItem(choice).getPrice())); 
    }

    @Override
    public void loadInventory() throws ItemPersistenceException {

    }

    @Override
    public void writeInventory() throws ItemPersistenceException {

    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(inventory.values());
    }

    @Override
    public BigDecimal getInsertedmoney() {
        return insertedMoney;
    }

}
