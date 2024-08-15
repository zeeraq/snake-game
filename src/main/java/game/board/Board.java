package game.board;

import game.commons.Bound;
import game.commons.EntityType;

public interface Board {

    Cell getCell(int x, int y);

    void addSnakeToPosition(int x, int y);

    void removeSnakeFromPosition(int x, int y);

    Bound getBoundFor(EntityType entityType);
}
