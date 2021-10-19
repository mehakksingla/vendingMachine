/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingMachine.serviceLayer;

import com.sg.vendingMachine.dao.InsufficientFundsException;
import com.sg.vendingMachine.dao.ItemPersistenceException;
import com.sg.vendingMachine.dao.ZeroInventoryException;
import com.sg.vendingMachine.dto.Change;
import com.sg.vendingMachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Mehak Singla
 */
public interface vendingMachineServiceLayer {
    
    /**
     * Takes user amount of money input and calls the Dao to update insertedMoney if
     * the amount is valid according to business rules.
     * @param money
     * @return
     * @throws PettyCashException
     * @throws InvalidInputException
     * @throws ItemPersistenceException
     */
    public boolean setInsertedMoney(BigDecimal money) throws PettyCashException, InvalidInputException, ItemPersistenceException;
    
    /**
     * Takes the user item choice and calls vendItem() in dao if
     * the item has stock and the user has enough funds
     * @param choice
     * @return
     * @throws InsufficientFundsException
     * @throws ZeroInventoryException
     * @throws ItemPersistenceException
     */
    public Change vendItem(String choice) throws InsufficientFundsException, ZeroInventoryException, ItemPersistenceException;
    
    /**
     * dao returnMoney() pass through method
     * @return
     * @throws ItemPersistenceException
     */
    public Change returnMoney() throws ItemPersistenceException;
    
    /**
     * dao getAllItems() pass through method
     * @return
     */
    public List<Item> getAllItems();
    
    /**
     * dao loadInvenotry() pass through method
     * @throws ItemPersistenceException
     */
    public void loadInventory() throws ItemPersistenceException;
    
    /**
     * dao writeInventory() pass through method
     * @throws ItemPersistenceException
     */
    public void writeInventory() throws ItemPersistenceException;
   
}
    
