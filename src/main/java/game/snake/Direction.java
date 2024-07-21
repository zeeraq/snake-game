package game.snake;

public enum Direction {
    UP,
    LEFT,
    DOWN,
    RIGHT,
    ;

    static {
        UP.opposite = DOWN;
        DOWN.opposite = UP;
        LEFT.opposite = RIGHT;
        RIGHT.opposite = LEFT;
    }

    private Direction opposite;

    Direction getOpposite() {
        return this.opposite;
    }
}
