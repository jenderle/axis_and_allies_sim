package enderlej.units.sea;

import enderlej.units.Unit;

/**
 * CREATED: 4/8/2017
 *
 * @author enderlej
 * @version 1
 */
public class Battleship extends Unit {
    private static final int BATTLESHIP_ATTACK = 4;
    private static final int BATTLESHIP_DEFENSE = 4;

    private int health = 2;

    public Battleship() {
        super(BATTLESHIP_ATTACK, BATTLESHIP_DEFENSE);
    }

    /**
     * Takes a hit to the Battleship's health. Return true if it's still alive
     * @return true if alive, else false if dead
     */
    public boolean takeHit() {
        health--;
        return health > 0;
    }
}
