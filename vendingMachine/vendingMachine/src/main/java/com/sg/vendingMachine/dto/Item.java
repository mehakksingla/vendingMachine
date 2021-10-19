/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.vendingMachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Mehak Singla 
 */
public class Item {
    
    private String name, menuKey;
    private int stock;
    private BigDecimal price;

    public Item(String menuKey, String name, String price, String stock) {
        this.menuKey = menuKey;
        this.name = name;
        this.price = new BigDecimal(price);
        this.stock = Integer.parseInt(stock);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public void vend(){
        stock--;
    }
}
    