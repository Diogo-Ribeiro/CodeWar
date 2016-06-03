package org.academiadecodigo.codewar;

/**
 * Created by codecadet on 25/05/16.
 */

public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    /**
     * The getRandomX() gives a random Direction.
     *
     * @return Direction
     */

    public static Direction getRandomX() {

        return RandomNumberGenerator.get(0, 1) < 1 ? LEFT : RIGHT;
    }

    /**
     * The getOppositeX() recieves the current direction and gives the oposite direction
     *
     * @param direction
     * @return
     */

    public static Direction getOppositeX(Direction direction) {

        return direction == LEFT ? RIGHT : LEFT;
    }
}
