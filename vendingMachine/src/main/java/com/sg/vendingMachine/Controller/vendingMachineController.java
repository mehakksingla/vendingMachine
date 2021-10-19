/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.vendingMachine.Controller;

import com.sg.vendingMachine.dao.vendingMachineDao;
import com.sg.vendingMachine.dao.ItemPersistenceException;
import com.sg.vendingMachine.dto.Change;
import com.sg.vendingMachine.serviceLayer.InsufficientFundsException;
import com.sg.vendingMachine.serviceLayer.InvalidInputException;
import com.sg.vendingMachine.serviceLayer.PettyCashException;
import com.sg.vendingMachine.serviceLayer.ZeroInventoryException;
import com.sg.vendingMachine.ui.vendingMachineView;
import com.sg.vendingMachine.serviceLayer.vendingMachineServiceLayer;

/**
 * @author Mehak Singla
 */
public class vendingMachineController {
   
    private vendingMachineServiceLayer service;
    private vendingMachineView view;
  

    public vendingMachineController(vendingMachineServiceLayer service, vendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() {
        boolean exit = false;
        
        try {
            service.loadInventory();
        while (!exit) {
            view.displayItemMenuChoices(service.getAllItems());
            switch (view.getMainMenuChoice()) {
                case 1:
                   makePurchase();
                   break;
                case 2:
                    exit = true;
                    break;
                }
            }
        service.writeInventory();
        }
        catch(ItemPersistenceException e){
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private void makePurchase() throws ItemPersistenceException {
        Change change = null;
        boolean validInsert = false;
        try{
            validInsert = service.setInsertedMoney(view.inputMoney());
            change = service.vendItem(view.getItemMenuChoice());
            view.displayVended();
        }
        catch(InsufficientFundsException | ZeroInventoryException | InvalidInputException | PettyCashException e) {
            view.displayErrorMessage(e.getMessage());
        }
        finally{
            if(validInsert){
                countChange(change);
            }
        }
    }
    
    private void countChange(Change change) throws ItemPersistenceException {
        if(change == null) { //VM errored out because of lack of funds/stock; return user money
            change= service.returnMoney();
            view.displayRefund(change);
        }
        else {
            view.displayChange(change);
        }
    }
}