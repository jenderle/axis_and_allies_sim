package enderlej.units.sea;

import enderlej.units.Unit;

/**
 * CREATED: 4/8/2017
 *
 * @author enderlej
 * @version 1
 */
public class Submarine extends Unit {
    private static final int SUBMARINE_ATTACK = 2;
    private static final int SUBMARINE_DEFENSE = 1;

    public Submarine() {
        super(SUBMARINE_ATTACK, SUBMARINE_DEFENSE);
    }
}
