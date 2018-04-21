package enderlej.units;

import enderlej.utils.Die;

/**
 * CREATED: 4/8/2017
 * Base class for any unit in A&A
 *
 * @author enderlej
 * @version 1
 */
public abstract class Unit {
    public final int ATTACK;
    public final int DEFENSE;

    public Unit(int attack, int defense) {
        ATTACK = attack;
        DEFENSE = defense;
    }

    public boolean attack() {
        Die die = new Die();
        return die.roll() <= ATTACK;
    }

    public boolean defend() {
        Die die = new Die();
        return die.roll() <= DEFENSE;
    }



}
