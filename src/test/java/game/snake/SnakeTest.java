package game.snake;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SnakeTest {

    private SnakeFactory snakeFactory;

    @BeforeEach
    void setup() {
        snakeFactory = SnakeFactory.getInstance();
    }

    @AfterEach
    void teardown() {
        snakeFactory = null;
    }

    @Test
    public void create_snakeShouldBeNonNull() {
        Snake snake = snakeFactory.createSnake();
        Assertions.assertNotNull(snake);
    }

    @Test
    public void getHeadOrientation_shouldBeAtOriginUponCreation() {
        Snake snake = snakeFactory.createSnake();
        Orientation headOrientation = snake.getHeadOrientation();
        Assertions.assertEquals(0, headOrientation.getXCoordinate());
        Assertions.assertEquals(0, headOrientation.getYCoordinate());
    }

    @Test
    public void getHeadOrientation_shouldBeMovingUpUponCreation() {
        Snake snake = snakeFactory.createSnake();
        Orientation headOrientation = snake.getHeadOrientation();
        Assertions.assertEquals(Direction.UP, headOrientation.getDirection());
    }

    @Test
    public void changeDirection_directionShouldChangeToTheEnteredValue() {
        Snake snake = snakeFactory.createSnake();
        Orientation headOrientation = snake.getHeadOrientation();
        Assertions.assertEquals(Direction.UP, headOrientation.getDirection());

        snake.changeDirection(Direction.LEFT);

        Assertions.assertEquals(Direction.LEFT, headOrientation.getDirection());
    }

    @Test
    public void changeDirection_changedDirectionIsOppositeOfCurrentDirection_upToDown_directionStaysSame() {
        Snake snake = snakeFactory.createSnake();
        Orientation headOrientation = snake.getHeadOrientation();
        Assertions.assertEquals(Direction.UP, headOrientation.getDirection());

        snake.changeDirection(Direction.DOWN);

        Assertions.assertEquals(Direction.UP, headOrientation.getDirection());
    }

    @Test
    public void changeDirection_changedDirectionIsOppositeOfCurrentDirection_leftToRight_directionStaysSame() {
        Snake snake = snakeFactory.createSnake();
        snake.changeDirection(Direction.LEFT);
        Orientation headOrientation = snake.getHeadOrientation();
        Assertions.assertEquals(Direction.LEFT, headOrientation.getDirection());

        snake.changeDirection(Direction.RIGHT);

        Assertions.assertEquals(Direction.LEFT, headOrientation.getDirection());
    }

    @Test
    public void move_headPositionShouldChangeAsPerOrientation() {
        Snake snake = snakeFactory.createSnake();

        Orientation headOrientationBeforeMove = snake.getHeadOrientation();
        Assertions.assertEquals(0, headOrientationBeforeMove.getXCoordinate());
        Assertions.assertEquals(0, headOrientationBeforeMove.getYCoordinate());
        Assertions.assertEquals(Direction.UP, headOrientationBeforeMove.getDirection());

        snake.move();

        Orientation headOrientationAfterMove = snake.getHeadOrientation();
        Assertions.assertEquals(0, headOrientationAfterMove.getXCoordinate());
        Assertions.assertEquals( 1, headOrientationAfterMove.getYCoordinate());
        Assertions.assertEquals(Direction.UP, headOrientationAfterMove.getDirection());
    }

    @Test
    public void moveTwiceAfterCreation_yShouldBecome2() {
        Snake snake = snakeFactory.createSnake();
        snake.move();
        snake.move();
        Orientation headOrientationAfterMove = snake.getHeadOrientation();
        Assertions.assertEquals( 2, headOrientationAfterMove.getYCoordinate());
    }

    @Test
    public void move_currentDirectionIsRight_xCoordinateIncrementsOnMove() {
        Snake snake = snakeFactory.createSnake();
        snake.changeDirection(Direction.RIGHT);
        Orientation headOrientation = snake.getHeadOrientation();
        Assertions.assertEquals(0, headOrientation.getXCoordinate());

        snake.move();

        Assertions.assertEquals(1, headOrientation.getXCoordinate());
    }

    @Test
    public void move_currentDirectionIsLeft_xCoordinateDecrementsOnMove() {
        Snake snake = snakeFactory.createSnake();
        snake.changeDirection(Direction.LEFT);
        Orientation headOrientation = snake.getHeadOrientation();
        Assertions.assertEquals(0, headOrientation.getXCoordinate());

        snake.move();

        Assertions.assertEquals(-1, headOrientation.getXCoordinate());
    }

    @Test
    public void move_currentDirectionIsDown_yCoordinateDecrementsOnMove() {
        Snake snake = snakeFactory.createSnake();
        snake.changeDirection(Direction.LEFT);
        snake.changeDirection(Direction.DOWN);
        Orientation headOrientation = snake.getHeadOrientation();
        Assertions.assertEquals(0, headOrientation.getYCoordinate());

        snake.move();

        Assertions.assertEquals(-1, headOrientation.getYCoordinate());

    }



}
