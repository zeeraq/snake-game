package game.snake;


public class SnakeFactory {

    private static SnakeFactory snakeFactory;

    private SnakeFactory() {

    }

    public static SnakeFactory getInstance() {
        if (snakeFactory == null) {
            snakeFactory = new SnakeFactory();
        }
        return snakeFactory;
    }

    public Snake createSnake() {
        return new SnakeImpl();
    }

}
