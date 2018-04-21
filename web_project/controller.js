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
            alert("Running... [Placeholder]");            
        };

    }


}