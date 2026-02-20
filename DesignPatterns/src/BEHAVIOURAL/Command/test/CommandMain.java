package BEHAVIOURAL.Command.test;

import BEHAVIOURAL.Command.model.*;

public class CommandMain {
    public static void main(String[] args) {
        Light light=new Light();
        Command off=new LightOffCommand(light);
        Command on=new LightOnCommand(light);

        Button button=new Button();
        button.setState(on);
        button.pressButton();
        button.setState(off);
        button.pressButton();
    }
}
