package game.snake;

public class Orientation {

    private int y;
    private int x;
    private Direction direction;

    public Orientation(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    int getXCoordinate() {
        return x;
    }

    int getYCoordinate() {
        return y;
    }

    Direction getDirection() {
        return direction;
    }

    void incrementY() {
        this.y++;
    }

    void decrementY() {
        this.y--;
    }

    void incrementX() {
        this.x++;
    }

    void decrementX() {
        this.x--;
    }

    void setDirection(Direction direction) {
        this.direction = direction;
    }
}

