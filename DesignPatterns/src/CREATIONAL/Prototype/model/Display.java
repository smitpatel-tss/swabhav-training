package CREATIONAL.Prototype.model;

public class Display {
    private double size;
    private String resolution;
    private int refreshRate;
    private boolean amoled;

    public Display(double size, String resolution, int refreshRate, boolean amoled) {
        this.size = size;
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.amoled = amoled;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setAmoled(boolean amoled) {
        this.amoled = amoled;
    }

    public Display(Display oldDisplay) {
        this.size = oldDisplay.size;
        this.resolution = oldDisplay.resolution;
        this.refreshRate = oldDisplay.refreshRate;
        this.amoled = oldDisplay.amoled;
    }

    @Override
    public String toString() {
        return "[size=" + size +
                ", resolution=" + resolution +
                ", refreshRate=" + refreshRate + "Hz" +
                ", amoled=" + amoled + "]";
    }

}