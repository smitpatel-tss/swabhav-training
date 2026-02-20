package TicTacToe;

public class Player {

    private String name;
    private int symbol;

    public Player(String name, int symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public int getSymbol() {
        return symbol;
    }
}