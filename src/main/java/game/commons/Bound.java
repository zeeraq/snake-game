package game.commons;

import java.util.concurrent.ThreadLocalRandom;

public class Bound {

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    public Bound(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public Position generateRandonPosition() {

        return new Position(generateARandomNumberInRange(minX, maxX), generateARandomNumberInRange(minY, maxY));
    }

    private int generateARandomNumberInRange(int min, int max) {
       return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
