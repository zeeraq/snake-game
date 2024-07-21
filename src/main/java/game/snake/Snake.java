package game.snake;

public interface Snake {

    Orientation getHeadOrientation();

    void changeDirection(Direction direction);

    void move();

}
