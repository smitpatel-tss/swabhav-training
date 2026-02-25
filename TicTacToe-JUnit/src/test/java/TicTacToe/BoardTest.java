package TicTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board;

    @BeforeEach
    void init(){
        board=new Board(3);
    }

    @Test
    void placeMove() {
        assertTrue(board.placeMove(2,2,1));
        assertFalse(board.placeMove(2,2,0));
    }

    @Test
    void isFull() {
        assertFalse(board.isFull());
        board.placeMove(0,0,1);
        board.placeMove(0,1,1);
        board.placeMove(0,2,1);
        board.placeMove(1,0,1);
        board.placeMove(1,1,1);
        board.placeMove(1,2,1);
        board.placeMove(2,0,1);
        board.placeMove(2,1,1);
        board.placeMove(2,2,1);
        assertTrue(board.isFull());

    }

    @Test
    void winCheck() {
        board.placeMove(0,0,1);
        board.placeMove(0,1,1);
        board.placeMove(0,2,1);

        assertTrue(board.winCheck(1));
        assertFalse(board.winCheck(0));

        board.placeMove(0,0,1);
        board.placeMove(1,0,1);
        board.placeMove(2,0,1);

        assertTrue(board.winCheck(1));
        assertFalse(board.winCheck(0));

        board.placeMove(0,0,1);
        board.placeMove(1,1,1);
        board.placeMove(2,2,1);

        assertTrue(board.winCheck(1));
        assertFalse(board.winCheck(0));

        board.placeMove(0,2,1);
        board.placeMove(1,1,1);
        board.placeMove(2,0,1);

        assertTrue(board.winCheck(1));
        assertFalse(board.winCheck(0));

    }
}