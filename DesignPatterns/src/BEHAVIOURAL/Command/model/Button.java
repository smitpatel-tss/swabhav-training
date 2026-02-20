package BEHAVIOURAL.Command.model;

public class Button {
    Command command;

    public void setState(Command command){
        this.command=command;
    }
    public void pressButton(){
        System.out.println("Button Pressed...");
        command.execute();
    }
}
