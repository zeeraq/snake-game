package game.board;

class CellImpl implements Cell {

    private int x;
    private int y;

    protected CellImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
