class Army {

    // Create army with these troops
    constructor(inf, art, tnk, ftr, bmb) {
        this.inf = Number(inf);
        this.art = Number(art);
        this.tnk = Number(tnk);
        this.ftr = Number(ftr);
        this.bmb = Number(bmb);        
    }
    
    // Use troops to generate hits, based off attacking rules
    attackVolley() {
        var hits = 0;

        // Calculate number of artillery-supported infantry
        var supported_inf = 0;
        var unsupported_inf = this.inf;
        var supporting_art = this.art;
        while(supporting_art > 0) {
            supporting_art--;
            supported_inf++;
            unsupported_inf--;
        }

        for(var i=0; i<unsupported_inf; i++) {
            if(this.rollDie() <= 1) {
                hits++;
            }
        }

        for(var i=0; i<(this.art + supported_inf); i++) {
            if(this.rollDie() <= 2) {
                hits++;
            }
        }

        for(var i=0; i<this.tnk; i++) {
            if(this.rollDie() <= 3) {
                hits++;
            }
        }

        for(var i=0; i<this.ftr; i++) {
            if(this.rollDie() <= 3) {
                hits++;
            }
        }

        for(var i=0; i<this.bmb; i++) {
            if(this.rollDie() <= 4) {
                hits++;
            }
        }      

        return hits;
    }

    // Use troops to generate hits, based off defending rules
    defenseVolley() {
        var hits = 0;

        for(var i=0; i<this.inf; i++) {
            if(this.rollDie() <= 2) {
                hits++;
            }
        }

        for(var i=0; i<this.art; i++) {
            if(this.rollDie() <= 2) {
                hits++;
            }
        }

        for(var i=0; i<this.tnk; i++) {
            if(this.rollDie() <= 3) {
                hits++;
            }
        }

        for(var i=0; i<this.ftr; i++) {
            if(this.rollDie() <= 4) {
                hits++;
            }
        }

        for(var i=0; i<this.bmb; i++) {
            if(this.rollDie() <= 1) {
                hits++;
            }
        }      

        return hits;
    }

    // Absorb hits with troops as an attacker
    takeHitsAttacker(hits) {
        while(hits > 0 && this.inf > 0) {
            hits--;
            this.inf--;
        }

        while(hits > 0 && this.art > 0) {
            hits--;
            this.art--;
        }

        while(hits > 0 && this.tnk > 0) {
            hits--;
            this.tnk--;
        }

        while(hits > 0 && this.ftr > 0) {
            hits--;
            this.ftr--;
        }

        while(hits > 0 && this.bmb > 0) {
            hits--;
            this.bmb--;
        }

        return this.isAlive();
    }

    // Absorb hits with troops as a defender
    takeHitsDefender(hits) {
        while(hits > 0 && this.inf > 0) {
            hits--;
            this.inf--;
        }

        // In major battles, can assume defenders would ditch useless bombers
        while(hits > 0 && this.bmb > 0) {
            hits--;
            this.bmb--;
        }

        while(hits > 0 && this.art > 0) {
            hits--;
            this.art--;
        }

        while(hits > 0 && this.tnk > 0) {
            hits--;
            this.tnk--;
        }

        while(hits > 0 && this.ftr > 0) {
            hits--;
            this.ftr--;
        }

        return this.isAlive();
    }

    // Check whether army is alive (total troops > 0)
    isAlive() {
        return this.inf > 0 || this.art > 0 || this.tnk > 0 || this.ftr > 0 || this.bmb > 0;
    }

    // Roll a six-sided die
    rollDie() {
        return Math.floor(Math.random()*6)+1;
    }

    // Have this army fight another army.
    // The calling army is the attacker; the parameter is the defender.
    // Return whether the attack was successful.
    attack(defender) {
        while(this.isAlive() && defender.isAlive()) {
            var atk_hits = this.attackVolley();
            var def_hits = defender.defenseVolley();

            this.takeHitsAttacker(def_hits);
            defender.takeHitsDefender(atk_hits);
        }

        return this.isAlive();
    }


}