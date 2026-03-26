package com.example.lab3.model;

import com.example.lab3.service.Warehouse;


public class Apple implements Storable {
    private final String name = "Fresh Apple";
    @Override
    public void goToWarehouse(Warehouse warehouse) {
        warehouse.putItem(this);
    }
    @Override
    public String getName() { return name; }
}