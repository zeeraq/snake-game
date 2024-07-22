package game.snake;

class SnakeImpl implements Snake {

    private Orientation headOrientation;

    public SnakeImpl() {
        this.headOrientation = new Orientation(0, 0, Direction.UP);
    }

    @Override
    public void changeDirection(Direction direction) {
        if (headOrientation.getDirection().getOpposite() != direction) {
            headOrientation.setDirection(direction);
        }
    }

    @Override
    public void move() {
        switch (headOrientation.getDirection()) {
            case UP:
                headOrientation.incrementY();
                break;
            case DOWN:
                headOrientation.decrementY();
                break;
            case LEFT:
                headOrientation.decrementX();
                break;
            case RIGHT:
                headOrientation.incrementX();
                break;
        }
    }

    @Override
    public int getHeadX() {
        return headOrientation.getXCoordinate();
    }

    @Override
    public int getHeadY() {
        return headOrientation.getYCoordinate();
    }

    @Override
    public Direction getHeadDirection() {
        return headOrientation.getDirection();
    }
}
