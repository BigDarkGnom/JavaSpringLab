package com.example.lab3.model;

import com.example.lab3.service.Warehouse;

public interface Storable {
    void goToWarehouse(Warehouse warehouse);
    String getName();
}