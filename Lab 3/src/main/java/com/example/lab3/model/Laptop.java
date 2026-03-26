package com.example.lab3.model;

import com.example.lab3.service.Warehouse;

public class Laptop implements Storable {
    private final String name = "Laptop Gaming X";
    @Override
    public void goToWarehouse(Warehouse warehouse) {
        warehouse.putItem(this);
    }
    @Override
    public String getName() { return name; }
}

