package game.board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BoardTest {

    public static final int BOARD_WIDTH = 200;
    public static final int BOARD_HEIGHT = 150;
    private BoardFactory boardFactory;

    @BeforeEach
    public void setup() {
        boardFactory = BoardFactory.getInstance();
    }

    @AfterEach
    public void teardown() {
        boardFactory = null;
    }

    @Test
    public void createBoard_boardIsNotNull() {
        Board board = boardFactory.createBoard(0, 0);
        Assertions.assertNotNull(board);
    }

    @Test
    public void createBoard_specifyBoardSize_boardIsNotNull() {
        Board board = boardFactory.createBoard(5, 10);
        Assertions.assertNotNull(board);
    }

    @Test
    public void getCell_cellPositionInBounds_cellIsNotNull() {
        Board board = boardFactory.createBoard(BOARD_WIDTH, BOARD_HEIGHT);
        Assertions.assertNotNull(board.getCell(0, 0));
        Assertions.assertNotNull(board.getCell(BOARD_WIDTH - 1, 0));
        Assertions.assertNotNull(board.getCell(BOARD_WIDTH - 1, BOARD_HEIGHT - 1));
        Assertions.assertNotNull(board.getCell(0, BOARD_HEIGHT - 1));
    }

    @Test
    public void getCell_cellPositionOutOfBounds_throwsException() {
        Board board = boardFactory.createBoard(BOARD_WIDTH, BOARD_HEIGHT);
        Assertions.assertThrows(RuntimeException.class, () -> board.getCell(-1, -1));
        Assertions.assertThrows(RuntimeException.class, () -> board.getCell(BOARD_WIDTH, 0));
        Assertions.assertThrows(RuntimeException.class, () -> board.getCell(0, BOARD_HEIGHT));
        Assertions.assertThrows(RuntimeException.class, () -> board.getCell(BOARD_WIDTH, BOARD_HEIGHT));
    }

    @Test
    public void getCell_cellPositionMatchesWithRequestedCoordinates() {
        Board board = boardFactory.createBoard(BOARD_WIDTH, BOARD_HEIGHT);
        Cell cell1 = board.getCell(45, 13);
        Assertions.assertEquals(45, cell1.getX());
        Assertions.assertEquals(13, cell1.getY());

        Cell cell2 = board.getCell(10, 33);
        Assertions.assertEquals(10, cell2.getX());
        Assertions.assertEquals(33, cell2.getY());
    }

}
