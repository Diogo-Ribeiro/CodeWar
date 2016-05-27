package org.academiadecodigo.codewar;

/**
 * Created by codecadet on 25/05/16.
 */
public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    public static Direction getRandom() {

        return RandomNumberGenerator.get(0, 1) < 1 ? LEFT : RIGHT;
    }

    public static Direction getOpposite(Direction direction) {

        return direction == LEFT ? RIGHT : LEFT;
    }
}
