class Controller {

    constructor() {
        var self = this;
        $().ready(function () {
            self.onLoad();
        });
    }
    
    onLoad() {
        self = this;

        // attach listener to button
        $('#run').click(function() {
            runSimulation();
        });


        // Run the battle simulation
        var runSimulation = function () {
            var atk_inf = $("#atk_inf").val();
            var atk_art = $("#atk_art").val();
            var atk_tnk = $("#atk_tnk").val();
            var atk_ftr = $("#atk_ftr").val();
            var atk_bmb = $("#atk_bmb").val();

            var def_inf = $("#def_inf").val();
            var def_art = $("#def_art").val();
            var def_tnk = $("#def_tnk").val();
            var def_ftr = $("#def_ftr").val();
            var def_bmb = $("#def_bmb").val();

            var atk_wins = 0;
            for(var i=0; i<100000; i++) {
                var atk_army = new Army(atk_inf, atk_art, atk_tnk, atk_ftr, atk_bmb);
                var def_army = new Army(def_inf, def_art, def_tnk, def_ftr, def_bmb);
                if(atk_army.attack(def_army)) {
                    atk_wins++;
                }
            }
            
            var results = $('#results');
            results.text("Attackers win " + (atk_wins / 100000 * 100) + "% of the battles.");
        };

    }


}