package game.snake;

public interface Snake {

    void changeDirection(Direction direction);

    void move();

    int getHeadX();

    int getHeadY();

    Direction getHeadDirection();

}
