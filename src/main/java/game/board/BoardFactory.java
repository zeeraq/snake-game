package game.board;

public class BoardFactory {

    private static BoardFactory boardFactory;

    private BoardFactory() {

    }

    public static BoardFactory getInstance() {
        if (boardFactory == null) {
            boardFactory = new BoardFactory();
        }
        return boardFactory;
    }

    public Board createBoard(int width, int height) {
        return new BoardImpl(width, height);
    }
}
