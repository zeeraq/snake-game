package game.board;

import java.awt.*;

class BoardImpl implements Board {

    private final int width;
    private final int height;

    private Cell[][] boardCells;

    public BoardImpl(int width, int height) {
        this.width = width;
        this.height = height;
        this.boardCells = new Cell[this.width][this.height];
        initialiseBoard();
    }

    private void initialiseBoard() {
        for (int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.height; j++) {
                this.boardCells[i][j] = new CellImpl(i, j, Color.WHITE);
            }
        }
    }

    @Override
    public Cell getCell(int x, int y) {
        validateCoordinateInBounds(x, y);
        return boardCells[x][y];
    }

    @Override
    public void addSnakeToPosition(int x, int y) {
        ((CellImpl) boardCells[x][y]).setColor(Color.BLACK);
    }

    @Override
    public void removeSnakeFromPosition(int x, int y) {
        ((CellImpl) boardCells[x][y]).setColor(Color.WHITE);
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
