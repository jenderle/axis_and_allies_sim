package enderlej.units.sea;

import enderlej.units.Unit;

/**
 * CREATED: 4/8/2017
 *
 * @author enderlej
 * @version 1
 */
public class Destroyer extends Unit {
    private static final int DESTROYER_ATTACK = 3;
    private static final int DESTROYER_DEFENSE = 3;

    public Destroyer() {
        super(DESTROYER_ATTACK, DESTROYER_DEFENSE);
    }


}
