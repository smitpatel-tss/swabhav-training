package com.tss.VehicleManagement;

public interface ElectricVehicle extends Vehicle{
    default void charge(){
        System.out.println("Charging...");
    }
}
