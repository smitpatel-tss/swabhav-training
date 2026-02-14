package CREATIONAL.Builder.model;

public class Game {
    private String gameName;
    private int difficultyLevel;
    private Platform platform;
    private String mainCharacterName;
    private boolean backgroundMusicEnabled;

    private Game(Builder builder) {
        this.gameName = builder.gameName;
        this.difficultyLevel = builder.difficultyLevel;
        this.platform = builder.platform;
        this.mainCharacterName = builder.mainCharacterName;
        this.backgroundMusicEnabled = builder.backgroundMusicEnabled;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameName='" + gameName + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                ", platform=" + platform +
                ", mainCharacterName='" + mainCharacterName + '\'' +
                ", backgroundMusicEnabled=" + backgroundMusicEnabled +
                '}';
    }

    public static class Builder{

        private String gameName;
        private Platform platform;

        private int difficultyLevel=5;
        private String mainCharacterName="User";
        private boolean backgroundMusicEnabled=false;

        public Builder(String gameName,Platform platform){

            if(gameName==null || gameName.isEmpty()){
                throw new IllegalArgumentException("Game Name should not be Empty!");
            }
            if(platform==null){
                throw new IllegalArgumentException("Specify Game Platform!");
            }
            this.gameName=gameName;
            this.platform=platform;
        }
        public Builder difficultyLevel(int level){
            this.difficultyLevel=level;
            return this;
        }
        public Builder mainCharacterName(String name){
            this.mainCharacterName=name;
            return this;
        }
        public Builder backgroundMusicEnabled(boolean enable){
            this.backgroundMusicEnabled=enable;
            return this;
        }

        public Game build(){
            return new Game(this);
        }
    }
}
