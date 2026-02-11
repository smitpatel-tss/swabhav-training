package com.tss.VehicleManagement;

public interface NonElectric extends Vehicle {
    default void getFuelStatus() {
        System.out.println("print fuel status");
    }
}
