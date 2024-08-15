package game.board;

import game.commons.Bound;
import game.commons.EntityType;
import game.commons.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;

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

    @Test
    public void addSnakeToPosition_cellColorForThePosition_changesFromWhiteToBlack() {
        Board board = boardFactory.createBoard(BOARD_WIDTH, BOARD_HEIGHT);
        Cell cell = board.getCell(13,34);
        Assertions.assertEquals(Color.WHITE, cell.getColor());
        board.addSnakeToPosition(13, 34);
        Assertions.assertEquals(Color.BLACK, cell.getColor());
    }

    @Test
    public void removeSnakeFromPosition_cellColor_changesFromBlackToWhite() {
        Board board = boardFactory.createBoard(BOARD_WIDTH, BOARD_HEIGHT);
        Cell cell = board.getCell(13,34);
        board.addSnakeToPosition(13, 34);
        Assertions.assertEquals(Color.BLACK, cell.getColor());
        board.removeSnakeFromPosition(13, 34);
        Assertions.assertEquals(Color.WHITE, cell.getColor());
    }

    @Test
    public void getInitialisationBound_forSnake_nonNull() {
        Board board = boardFactory.createBoard(200, 150);
        Bound bound = board.getBoundFor(EntityType.SNAKE);
        Assertions.assertNotNull(bound);
    }

    @Test
    public void getInitialisationBound_forSnake_generatePosition_returnsPositionWithMinAndMaxOffsetOf10FromBoardBoundaries() {
        Board board = boardFactory.createBoard(200, 150);
        Bound bound = board.getBoundFor(EntityType.SNAKE);
        Position generatedPosition = bound.generateRandonPosition();

        Assertions.assertTrue(generatedPosition.getX() >= 10);
        Assertions.assertTrue(generatedPosition.getY() >= 10);

        Assertions.assertTrue(generatedPosition.getX() <= 189);
        Assertions.assertTrue(generatedPosition.getY() <= 139);
    }
}
