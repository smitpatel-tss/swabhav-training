package com.tss.VehicleManagement;

public class Car implements NonElectric {
    private final int id;
    private boolean isStarted;
    private boolean canPlayMusic;
    private boolean canPlayHorn;

    public Car(int id, boolean isStarted, boolean canPlayMusic, boolean canPlayHorn) {
        this.id = id;
        this.isStarted = isStarted;
        this.canPlayMusic = canPlayMusic;
        this.canPlayHorn = canPlayHorn;
    }

    @Override
    public int getId() {
        return id;
    }

    public boolean getIsStarted() {
        return isStarted;
    }

    public boolean getCanPlayMusic() {
        return canPlayMusic;
    }

    public boolean getCanPlayHorn() {
        return canPlayHorn;
    }

    public void setIsStarted(boolean started) {
        this.isStarted = started;
    }

    public void start() {
        if (!isStarted) {
            System.out.println("Starting the Car....");
        } else {
            System.out.println("Already Started!");
        }
    }
}
