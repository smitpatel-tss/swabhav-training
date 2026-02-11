package com.tss.VehicleManagement;

public class ElectricBike implements NonElectric {
    private final int id;
    private boolean isStarted;
    private boolean canPlayMusic;
    private boolean canPlayHorn;

    public ElectricBike(int id, boolean isStarted, boolean canPlayMusic, boolean canPlayHorn) {
        this.id = id;
        this.isStarted = isStarted;
        this.canPlayMusic = canPlayMusic;
        this.canPlayHorn = canPlayHorn;
    }

    public void charge() {
        System.out.println("Charging the car...");
    }

    @Override
    public int getId() {
        return id;
    }

    public boolean getIsStarted() {
        return isStarted;
    }

    public void setIsStarted(boolean started) {
        this.isStarted = started;
    }

    public boolean getCanPlayMusic() {
        return canPlayMusic;
    }


    public boolean getCanPlayHorn() {
        return canPlayHorn;
    }
}
