package enderlej.units;

import enderlej.units.land.Infantry;
import enderlej.units.land.Tank;

/**
 * CREATED: 4/8/2017
 *
 * @author enderlej
 * @version 1
 */
public class Battlefield {
    private final Army attackers;
    private final Army defenders;

    public Battlefield(Army attackers, Army defenders) {
        this.attackers = attackers;
        this.defenders = defenders;
    }

    /**
     * Resolves the battle
     * @return true if attack succeeded, else false if defenders won
     */
    public boolean play() {
        while(attackers.isAlive() && defenders.isAlive()) {
            int attackerHits = attackers.attackVolley();
            int defenderHits = defenders.defenseVolley();
            attackers.takeHits(defenderHits);
            defenders.takeHits(attackerHits);
        }
        return attackers.isAlive();
    }

    public static void main(String[] args) {
        int attackerWins = 0;
        for(int i=0; i<100000; i++) {
            Army atk = new Army();
            atk.addUnit(new Infantry());
            atk.addUnit(new Infantry());
            atk.addUnit(new Infantry());
            atk.addUnit(new Infantry());
            atk.addUnit(new Infantry());

            atk.addUnit(new Tank());
            atk.addUnit(new Tank());
            atk.addUnit(new Tank());

            Army def = new Army();

            def.addUnit(new Infantry());
            def.addUnit(new Infantry());
            def.addUnit(new Infantry());
            def.addUnit(new Infantry());
            def.addUnit(new Infantry());
            def.addUnit(new Infantry());
            def.addUnit(new Infantry());
            def.addUnit(new Infantry());
            def.addUnit(new Infantry());
            def.addUnit(new Infantry());

            Battlefield test = new Battlefield(atk, def);
            boolean result = test.play();
            if(result) {
                attackerWins++;
            }

            /*
            if(result) {
                System.out.println("Attackers won. They have left: ");
                System.out.println("Infantry: " + atk.getInfantry());
                System.out.println("Tanks: " + atk.getTanks());

                System.out.println("Defenders have: (should be zero)");
                System.out.println(def.getInfantry());
            } else {
                System.out.println("Defenders won. They have left: ");
                System.out.println("Infantry: " + def.getInfantry());

                System.out.println("Attackers have: (should be zero)");
                System.out.println("Infantry: " + atk.getInfantry());
                System.out.println("Tanks: " + atk.getTanks());
            }
            */
        }
        System.out.println("Attackers won " + attackerWins / 100000.0 * 100 + "% of the time.");


    }


}
