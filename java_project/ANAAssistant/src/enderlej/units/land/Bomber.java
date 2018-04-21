package enderlej.units.land;

import enderlej.units.Unit;

/**
 * CREATED: 4/8/2017
 *
 * @author enderlej
 * @version 1
 */
public class Bomber extends Unit {
    private static final int BOMBER_ATTACK = 4;
    private static final int BOMBER_DEFENSE = 1;

    public Bomber() {
        super(BOMBER_ATTACK,BOMBER_DEFENSE);
    }

    public static void main(String[] args) {
        Unit test = new Bomber();
        int hits = 0;
        for(int i=0; i<100000; i++) {
            if(test.attack()) {
                hits++;
            }
        }

        System.out.println("Number of hits on attack: " + hits + "/100,000");
        System.out.println("...or " + hits/100000.0 * 100 + "%");

        hits = 0;
        for(int i=0; i<100000; i++) {
            if(test.defend()) {
                hits++;
            }
        }

        System.out.println("Number of hits on defense: " + hits + "/100,000");
        System.out.println("...or " + hits/100000.0 * 100 + "%");
    }
}
