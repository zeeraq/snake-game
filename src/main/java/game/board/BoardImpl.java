package game.board;

class BoardImpl implements Board {

    private final int width;
    private final int height;

    public BoardImpl(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Cell getCell(int x, int y) {
        validateCoordinateInBounds(x, y);
        return new CellImpl(x, y);
    }

    private void validateCoordinateInBounds(int x, int y) {
        if (x < 0 || x >= width) {
            throw new RuntimeException();
        }
        if (y < 0 || y >= height) {
            throw new RuntimeException();
        }
    }

}
