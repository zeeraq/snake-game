package game.board;

public interface Board {

    Cell getCell(int x, int y);

    void addSnakeToPosition(int x, int y);

    void removeSnakeFromPosition(int x, int y);

}
