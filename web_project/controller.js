class Controller {

    constructor() {
        var self = this;
        $().ready(function () {
            self.onLoad();
        });
    } // end constructor
    
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
            
            var atk_army = new Army(atk_inf, atk_art, atk_tnk, atk_ftr, atk_bmb);
            console.log("Atk army is alive? " + atk_army.isAlive());
            
            var results = $('#results');
            results.text("Attackers have " + atk_inf + " infantry. Defenders have " + def_inf + " infantry.")
        };

    }


}