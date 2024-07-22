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
        Assertions.assertEquals(0, snake.getHeadX());
        Assertions.assertEquals(0, snake.getHeadY());
    }

    @Test
    public void getHeadOrientation_shouldBeMovingUpUponCreation() {
        Snake snake = snakeFactory.createSnake();
        Assertions.assertEquals(Direction.UP, snake.getHeadDirection());
    }

    @Test
    public void changeDirection_directionShouldChangeToTheEnteredValue() {
        Snake snake = snakeFactory.createSnake();
        Assertions.assertEquals(Direction.UP, snake.getHeadDirection());

        snake.changeDirection(Direction.LEFT);

        Assertions.assertEquals(Direction.LEFT, snake.getHeadDirection());
    }

    @Test
    public void changeDirection_changedDirectionIsOppositeOfCurrentDirection_upToDown_directionStaysSame() {
        Snake snake = snakeFactory.createSnake();
        Assertions.assertEquals(Direction.UP, snake.getHeadDirection());

        snake.changeDirection(Direction.DOWN);

        Assertions.assertEquals(Direction.UP, snake.getHeadDirection());
    }

    @Test
    public void changeDirection_changedDirectionIsOppositeOfCurrentDirection_leftToRight_directionStaysSame() {
        Snake snake = snakeFactory.createSnake();
        snake.changeDirection(Direction.LEFT);
        Assertions.assertEquals(Direction.LEFT, snake.getHeadDirection());

        snake.changeDirection(Direction.RIGHT);

        Assertions.assertEquals(Direction.LEFT, snake.getHeadDirection());
    }

    @Test
    public void move_headPositionShouldChangeAsPerOrientation() {
        Snake snake = snakeFactory.createSnake();

        Assertions.assertEquals(0, snake.getHeadX());
        Assertions.assertEquals(0, snake.getHeadY());
        Assertions.assertEquals(Direction.UP, snake.getHeadDirection());

        snake.move();

        Assertions.assertEquals(0, snake.getHeadX());
        Assertions.assertEquals( 1, snake.getHeadY());
        Assertions.assertEquals(Direction.UP, snake.getHeadDirection());
    }

    @Test
    public void move_currentDirectionIsRight_xCoordinateIncrementsOnMove() {
        Snake snake = snakeFactory.createSnake();
        snake.changeDirection(Direction.RIGHT);
        Assertions.assertEquals(0, snake.getHeadX());

        snake.move();

        Assertions.assertEquals(1, snake.getHeadX());
    }

    @Test
    public void move_currentDirectionIsLeft_xCoordinateDecrementsOnMove() {
        Snake snake = snakeFactory.createSnake();
        snake.changeDirection(Direction.LEFT);
        Assertions.assertEquals(0, snake.getHeadX());

        snake.move();

        Assertions.assertEquals(-1, snake.getHeadX());
    }

    @Test
    public void move_currentDirectionIsDown_yCoordinateDecrementsOnMove() {
        Snake snake = snakeFactory.createSnake();
        snake.changeDirection(Direction.LEFT);
        snake.changeDirection(Direction.DOWN);
        Assertions.assertEquals(0, snake.getHeadY());

        snake.move();

        Assertions.assertEquals(-1, snake.getHeadY());

    }

}
