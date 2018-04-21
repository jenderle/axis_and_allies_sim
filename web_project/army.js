class Army {

    constructor(inf, art, tnk, ftr, bmb) {
        this.inf = inf;
        this.art = art;
        this.tnk = tnk;
        this.ftr = ftr;
        this.bmb = bmb;        
    } // end constructor
    
    volley() {
        

    }

    takeHits(hits) {
        // Take hits to infantry
        while(hits > 0 && this.inf > 0) {
            hits = hits - 1;
            this.inf = this.inf - 1;
        }

        if(hits > 0 && this.art > 0) {
            hits = hits - 1;
            this.art = this.art - 1;
        }

        return this.isAlive();
    }

    isAlive() {
        return this.inf > 0 || this.art > 0 || this.tnk > 0 || this.ftr > 0 || this.bmb > 0;
    }


}