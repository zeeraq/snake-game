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
    public void move_headPositionShouldChangeAsPerOrientation() {
        Snake snake = snakeFactory.createSnake();

        Orientation headOrientationBeforeMove = snake.getHeadOrientation();
        Assertions.assertEquals(0, headOrientationBeforeMove.getXCoordinate());
        Assertions.assertEquals(0, headOrientationBeforeMove.getYCoordinate());
        Assertions.assertEquals(Direction.UP, headOrientationBeforeMove.getDirection());

        snake.move();

        Orientation headOrientationAfterMove = snake.getHeadOrientation();
        Assertions.assertEquals( 1, headOrientationAfterMove.getYCoordinate());
        Assertions.assertEquals(0, headOrientationAfterMove.getXCoordinate());
        Assertions.assertEquals(Direction.UP, headOrientationAfterMove.getDirection());
    }
}
