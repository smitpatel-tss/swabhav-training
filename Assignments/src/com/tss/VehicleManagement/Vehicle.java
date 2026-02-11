package com.tss.VehicleManagement;

public interface Vehicle {
    int getId();

    boolean getCanPlayMusic();

    boolean getCanPlayHorn();

    boolean getIsStarted();

    void setIsStarted(boolean started);

    default void horn() {
        if (this.getCanPlayHorn()) {
            System.out.println("Piii piiipppp");
        } else {
            System.out.println("HORN WORK NAHI KAR RAHAA :(");
        }
    }

    default void playMusic() {
        if (this.getCanPlayMusic()) {
            System.out.println("Lala la lala.. lala la lala.. lala la lalaaa....");
        } else {
            System.out.println("Feature Not Supported!");
        }
    }

    default void start() {
        if (this.getIsStarted()) {
            System.out.println(this.getClass().getSimpleName() + " is already started...");
        } else {
            System.out.println(this.getClass().getSimpleName() + " is Started...");
            this.setIsStarted(true);
        }
    }

    default void stop() {
        if (this.getIsStarted()) {
            System.out.println(this.getClass().getSimpleName() + " is stopped...");
            this.setIsStarted(false);
        } else {
            System.out.println(this.getClass().getSimpleName() + " is already stopped...");
        }
    }

    static void inspection(Vehicle myVehicle) {
        System.out.println(myVehicle.getClass().getSimpleName() + " -> Inspection Done!");
    }

    default void charge() {

        System.out.println("Feature Not Supported!");
    }

    default void getFuelStatus() {

        System.out.println("Feature Not Supported!");
    }
}
