package CREATIONAL.Prototype.model;

public class Phone implements Blueprint<Phone> {
    private String companyName;
    private String modelName;
    private String processor;
    private int battery;
    private Display display;

    public Phone(String companyName, String modelName, String processor, int battery, Display display) {
        this.companyName = companyName;
        this.modelName = modelName;
        this.processor = processor;
        this.battery = battery;
        this.display = display;
    }


    @Override
    public String toString() {
        return "companyName : '" + companyName + "'\n" +
                "modelName   : '" + modelName + "'\n" +
                "processor   : '" + processor + "'\n" +
                "battery     : " + battery + " mAh\n" +
                "display     : " + display;
    }

    public Display getDisplay() {
        return display;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Phone(Phone oldPhone) {
        this.companyName = oldPhone.companyName;
        this.modelName = oldPhone.modelName;
        this.processor = oldPhone.processor;
        this.battery = oldPhone.battery;
        this.display = new Display(oldPhone.display);
    }

    public Phone clone() {
        return new Phone(this);
    }
}
