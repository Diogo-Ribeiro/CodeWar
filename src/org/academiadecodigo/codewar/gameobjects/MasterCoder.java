package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.RandomNumberGenerator;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class MasterCoder extends Char {

    private MasterCoderType type;
    // TODO: 24/05/16 mcs open mouth to shoot kissies or dickies

    public MasterCoder (MasterCoderType type) {

        this.type = type;
    }

    public Projectile shoot () {
        // TODO: 25/05/16 think of an adequate shooting probability
        if (RandomNumberGenerator.get(0,10) < 3) {

            System.out.println("new projectile fired");
            return new Projectile();

        }

        System.out.println("didn't shoot");
        return null;
    }

}
