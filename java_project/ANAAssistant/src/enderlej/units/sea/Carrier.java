package enderlej.units.sea;

import enderlej.units.Unit;

/**
 * CREATED: 4/8/2017
 *
 * @author enderlej
 * @version 1
 */
public class Carrier extends Unit {
    private static final int CARRIER_ATTACK = 1;
    private static final int CARRIER_DEFENSE = 3;

    public Carrier() {
        super(CARRIER_ATTACK, CARRIER_DEFENSE);
    }
}
