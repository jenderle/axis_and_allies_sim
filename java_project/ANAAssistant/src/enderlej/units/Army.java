package enderlej.units;

import enderlej.units.land.*;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATED: 4/8/2017
 * Aggregates collections of Units to display firepower
 *
 * @author enderlej
 * @version 1
 */
public class Army {
    private List<Unit> infantries = new ArrayList<>();
    private List<Unit> artilleries = new ArrayList<>();
    private List<Unit> tanks = new ArrayList<>();
    private List<Unit> fighters = new ArrayList<>();
    private List<Unit> bombers = new ArrayList<>();


    private boolean dead = false;

    public void addUnit(Unit unit) {
        if(unit instanceof Infantry) {
            infantries.add(unit);
        }
        if(unit instanceof Artillery) {
            artilleries.add(unit);
        }
        if(unit instanceof Tank) {
            tanks.add(unit);
        }
        if(unit instanceof Fighter) {
            fighters.add(unit);
        }
        if(unit instanceof Bomber) {
            bombers.add(unit);
        }

        if(dead) {
            dead = false;
        }
    }

    public int attackVolley() {
        int hits = 0;
        for(Unit infantry : infantries) {
            if(infantry.attack()) {
                hits++;
            }
        }
        for(Unit artillery : artilleries) {
            if(artillery.attack()) {
                hits++;
            }
        }
        for(Unit tank : tanks) {
            if(tank.attack()) {
                hits++;
            }
        }
        for(Unit fighter : fighters) {
            if(fighter.attack()) {
                hits++;
            }
        }
        for(Unit bomber : bombers) {
            if(bomber.attack()) {
                hits++;
            }
        }

        return hits;
    }

    public int defenseVolley() {
        int hits = 0;
        for(Unit infantry : infantries) {
            if(infantry.defend()) {
                hits++;
            }
        }
        for(Unit artillery : artilleries) {
            if(artillery.defend()) {
                hits++;
            }
        }
        for(Unit tank : tanks) {
            if(tank.defend()) {
                hits++;
            }
        }
        for(Unit fighter : fighters) {
            if(fighter.defend()) {
                hits++;
            }
        }
        for(Unit bomber : bombers) {
            if(bomber.defend()) {
                hits++;
            }
        }

        return hits;
    }

    /**
     * Take specified no. of hits
     * @param hits no. of hits
     * @return true if killed by this volley, else false if still alive
     */
    public boolean takeHits(int hits) {
        while(!infantries.isEmpty() && hits > 0) {
            infantries.remove(0);
            hits--;
        }
        while(!artilleries.isEmpty() && hits > 0) {
            artilleries.remove(0);
            hits--; //RIP to the time lost debugging the fact that I forgot this line. lol
        }
        while(!tanks.isEmpty() && hits > 0) {
            tanks.remove(0);
            hits--;
        }
        while(!fighters.isEmpty() && hits > 0) {
            fighters.remove(0);
            hits--;
        }
        while(!bombers.isEmpty() && hits > 0) {
            bombers.remove(0);
            hits--;
        }

        dead = infantries.isEmpty() && artilleries.isEmpty() && tanks.isEmpty() && fighters.isEmpty() && bombers.isEmpty();

        return dead;
    }

    public boolean isAlive() {
        return !dead;
    }

    public static Army copyArmy(Army army) {
        Army newArmy = new Army();
        newArmy.infantries.addAll(army.infantries);
        newArmy.artilleries.addAll(army.artilleries);
        newArmy.tanks.addAll(army.tanks);
        newArmy.fighters.addAll(army.fighters);
        newArmy.bombers.addAll(army.bombers);
        return newArmy;
    }

    public int getInfantry() {
        return infantries.size();
    }

    public int getArtillery() {
        return artilleries.size();
    }

    public int getTanks() {
        return tanks.size();
    }

    public int getFighters() {
        return fighters.size();
    }

    public int getBombers() {
        return bombers.size();
    }


}
