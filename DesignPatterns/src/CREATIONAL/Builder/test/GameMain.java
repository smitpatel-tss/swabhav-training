package CREATIONAL.Builder.test;

import CREATIONAL.Builder.model.Game;
import CREATIONAL.Builder.model.Platform;

public class GameMain {
    public static void main(String[] args) {
        Game myGame=new Game.Builder("Clash of Clans", Platform.MOBILE)
                .mainCharacterName("Smit")
                .backgroundMusicEnabled(false)
                .build();

        System.out.println(myGame);
    }
}
