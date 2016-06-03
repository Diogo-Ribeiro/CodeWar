package org.academiadecodigo.codewar;

/**
 * This Class gives random numbers in a defined range.
 * Created by codecadet on 25/05/16.
 */
public class RandomNumberGenerator {

    public static int get(int min, int max) {

       return (int) (Math.random() * ((max-min)+1) + 0);
    }
}
