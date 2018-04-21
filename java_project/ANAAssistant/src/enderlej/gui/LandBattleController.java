/*
 * <TODO Course - Section>
 * <TODO Term>
 * <TODO Lab Assignment>
 * Name: enderlej
 * Created: 4/8/2017
 */
package enderlej.gui;


import enderlej.units.*;
import enderlej.units.land.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Controller for the Axis & Allies Assistant GUI
 *
 * @author enderlej
 */
public class LandBattleController {

    @FXML
    private TextField atkInfantryLabel;

    @FXML
    private TextField atkArtilleryLabel;

    @FXML
    private TextField atkTanksLabel;

    @FXML
    private TextField atkFightersLabel;

    @FXML
    private TextField atkBombersLabel;

    @FXML
    private TextField defInfantryLabel;

    @FXML
    private TextField defArtilleryLabel;

    @FXML
    private TextField defTanksLabel;

    @FXML
    private TextField defFightersLabel;

    @FXML
    private TextField defBombersLabel;

    @FXML
    private TextArea resultsArea;

    private Stage landStage;
    private Stage seaStage;
    private Stage researchStage;

    public void setLandStage(Stage landStage) {
        this.landStage = landStage;
    }
    public void setSeaStage(Stage seaStage) {
        this.seaStage = seaStage;
    }
    public void setResearchStage(Stage researchStage) {
        this.researchStage = researchStage;
    }


    /**
     * Initializes the controller class.
     *
     */
    @FXML
    public void initialize() {}

    @FXML
    public void handleRun(ActionEvent event) {
        int atkInfantry = getIntFromString(atkInfantryLabel.getText());
        int atkArtillery = getIntFromString(atkArtilleryLabel.getText());
        int atkTanks = getIntFromString(atkTanksLabel.getText());
        int atkFighters = getIntFromString(atkFightersLabel.getText());
        int atkBombers = getIntFromString(atkBombersLabel.getText());
        int atkUnits = atkInfantry + atkArtillery + atkTanks + atkFighters + atkBombers;

        int defInfantry = getIntFromString(defInfantryLabel.getText());
        int defArtillery = getIntFromString(defArtilleryLabel.getText());
        int defTanks = getIntFromString(defTanksLabel.getText());
        int defFighters = getIntFromString(defFightersLabel.getText());
        int defBombers = getIntFromString(defBombersLabel.getText());
        int defUnits = defInfantry + defArtillery + defTanks + defFighters + defBombers;

        Army atk = new Army();
        for(int i=0; i<atkInfantry; i++) {
            atk.addUnit(new Infantry());
        }
        for(int i=0; i<atkArtillery; i++) {
            atk.addUnit(new Artillery());
        }
        for(int i=0; i<atkTanks; i++) {
            atk.addUnit(new Tank());
        }
        for(int i=0; i<atkFighters; i++) {
            atk.addUnit(new Fighter());
        }
        for(int i=0; i<atkBombers; i++) {
            atk.addUnit(new Bomber());
        }

        Army def = new Army();
        for(int i=0; i<defInfantry; i++) {
            def.addUnit(new Infantry());
        }
        for(int i=0; i<defArtillery; i++) {
            def.addUnit(new Artillery());
        }
        for(int i=0; i<defTanks; i++) {
            def.addUnit(new Tank());
        }
        for(int i=0; i<defFighters; i++) {
            def.addUnit(new Fighter());
        }
        for(int i=0; i<defBombers; i++) {
            def.addUnit(new Bomber());
        }

        int aveAtkInfantry = 0;
        int aveAtkArtillery = 0;
        int aveAtkTanks = 0;
        int aveAtkFighters = 0;
        int aveAtkBombers = 0;

        int aveDefInfantry = 0;
        int aveDefArtillery = 0;
        int aveDefTanks = 0;
        int aveDefFighters = 0;
        int aveDefBombers = 0;


        int numberOfRuns = 100000;
        int attackerWinCount = 0;
        for(int i=0; i<numberOfRuns; i++) {
            Army attackers = Army.copyArmy(atk);
            Army defenders = Army.copyArmy(def);

            Battlefield battlefield = new Battlefield(attackers, defenders);
            boolean attackersWon = battlefield.play();

            if(attackersWon) {
                attackerWinCount++;
                aveAtkInfantry += attackers.getInfantry();
                aveAtkArtillery += attackers.getArtillery();
                aveAtkTanks += attackers.getTanks();
                aveAtkFighters += attackers.getFighters();
                aveAtkBombers += attackers.getBombers();
            } else {
                aveDefInfantry += defenders.getInfantry();
                aveDefArtillery += defenders.getArtillery();
                aveDefTanks += defenders.getTanks();
                aveDefFighters += defenders.getFighters();
                aveDefBombers += defenders.getBombers();
            }
        }

        if(attackerWinCount == 0) {
            attackerWinCount = 1;
        }
        if(attackerWinCount == numberOfRuns) {
            attackerWinCount = numberOfRuns - 1;
        }

        String results = "Attackers won " + round((double) attackerWinCount / numberOfRuns * 100) + "% of the battles.\n";
        results += "\n";
        results += "Typical troops left after an Attacker win:\n";
        results += "Infantry: " + round((double) aveAtkInfantry / attackerWinCount) + "\n";
        results += "Artillery: " + round((double) aveAtkArtillery / attackerWinCount) + "\n";
        results += "Tanks: " + round((double) aveAtkTanks / attackerWinCount) + "\n";
        results += "Fighters: " + round((double) aveAtkFighters / attackerWinCount) + "\n";
        results += "Bombers: " + round((double) aveAtkBombers / attackerWinCount) + "\n";

        results += "\n";

        results += "Typical troops left after a Defender win:\n";
        results += "Infantry: " + round((double) aveDefInfantry / (numberOfRuns - attackerWinCount)) + "\n";
        results += "Artillery: " + round((double) aveDefArtillery / (numberOfRuns - attackerWinCount)) + "\n";
        results += "Tanks: " + round((double) aveDefTanks / (numberOfRuns - attackerWinCount)) + "\n";
        results += "Fighters: " + round((double) aveDefFighters / (numberOfRuns - attackerWinCount)) + "\n";
        results += "Bombers: " + round((double) aveDefBombers / (numberOfRuns - attackerWinCount)) + "\n";

        resultsArea.setText(results);

    }

    @FXML
    public void about(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(resultsArea.getScene().getWindow());
        alert.setGraphic(new ImageView("ANAiconMini.png"));
        alert.setTitle("About");
        alert.setHeaderText("Aide-de-camp");
        alert.setContentText("Developed by Jonathan Enderle\non 4/8/17 at the RokkinCat Hack & Tell =)");

        alert.showAndWait();
    }

    @FXML
    public void clearArmies(ActionEvent event) {
        atkInfantryLabel.setText("0");
        atkArtilleryLabel.setText("0");
        atkTanksLabel.setText("0");
        atkFightersLabel.setText("0");
        atkBombersLabel.setText("0");

        defInfantryLabel.setText("0");
        defArtilleryLabel.setText("0");
        defTanksLabel.setText("0");
        defFightersLabel.setText("0");
        defBombersLabel.setText("0");

        resultsArea.setText("Nothing to show.");
    }

    @FXML
    public void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void handleLandStage(ActionEvent event) {
        seaStage.hide();
        landStage.show();
    }

    @FXML
    public void handleSeaStage(ActionEvent event) {
        landStage.hide();
        seaStage.show();
    }

    @FXML
    public void research(ActionEvent event) {
        researchStage.show();
    }


    //<editor-fold desc="Increment/Decrement Attacker Methods">
    @FXML
    public void incrementAtkInfantry(ActionEvent event) {
        String input = atkInfantryLabel.getText();
        int current = getIntFromString(input);
        atkInfantryLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementAtkInfantry(ActionEvent event) {
        String input = atkInfantryLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            atkInfantryLabel.setText(current - 1 + "");
        }
    }

    @FXML
    public void incrementAtkArtillery(ActionEvent event) {
        String input = atkArtilleryLabel.getText();
        int current = getIntFromString(input);
        atkArtilleryLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementAtkArtillery(ActionEvent event) {
        String input = atkArtilleryLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            atkArtilleryLabel.setText(current - 1 + "");
        }
    }

    @FXML
    public void incrementAtkTanks(ActionEvent event) {
        String input = atkTanksLabel.getText();
        int current = getIntFromString(input);
        atkTanksLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementAtkTanks(ActionEvent event) {
        String input = atkTanksLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            atkTanksLabel.setText(current - 1 + "");
        }
    }

    @FXML
    public void incrementAtkFighters(ActionEvent event) {
        String input = atkFightersLabel.getText();
        int current = getIntFromString(input);
        atkFightersLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementAtkFighters(ActionEvent event) {
        String input = atkFightersLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            atkFightersLabel.setText(current - 1 + "");
        }
    }

    @FXML
    public void incrementAtkBombers(ActionEvent event) {
        String input = atkBombersLabel.getText();
        int current = getIntFromString(input);
        atkBombersLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementAtkBombers(ActionEvent event) {
        String input = atkBombersLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            atkBombersLabel.setText(current - 1 + "");
        }
    }
    //</editor-fold>

    //<editor-fold desc="Increment/Decrement Defender Methods">
    @FXML
    public void incrementDefInfantry(ActionEvent event) {
        String input = defInfantryLabel.getText();
        int current = getIntFromString(input);
        defInfantryLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementDefInfantry(ActionEvent event) {
        String input = defInfantryLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            defInfantryLabel.setText(current - 1 + "");
        }
    }

    @FXML
    public void incrementDefArtillery(ActionEvent event) {
        String input = defArtilleryLabel.getText();
        int current = getIntFromString(input);
        defArtilleryLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementDefArtillery(ActionEvent event) {
        String input = defArtilleryLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            defArtilleryLabel.setText(current - 1 + "");
        }
    }

    @FXML
    public void incrementDefTanks(ActionEvent event) {
        String input = defTanksLabel.getText();
        int current = getIntFromString(input);
        defTanksLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementDefTanks(ActionEvent event) {
        String input = defTanksLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            defTanksLabel.setText(current - 1 + "");
        }
    }

    @FXML
    public void incrementDefFighters(ActionEvent event) {
        String input = defFightersLabel.getText();
        int current = getIntFromString(input);
        defFightersLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementDefFighters(ActionEvent event) {
        String input = defFightersLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            defFightersLabel.setText(current - 1 + "");
        }
    }

    @FXML
    public void incrementDefBombers(ActionEvent event) {
        String input = defBombersLabel.getText();
        int current = getIntFromString(input);
        defBombersLabel.setText(current + 1 + "");
    }

    @FXML
    public void decrementDefBombers(ActionEvent event) {
        String input = defBombersLabel.getText();
        int current = getIntFromString(input);
        if(current > 0) {
            defBombersLabel.setText(current - 1 + "");
        }
    }
    //</editor-fold>

    /**
     * Rounds to two digits
     * @param num number to round
     * @return number rounded to two digits as a String
     */
    private static String round(double num) {
        return String.format("%.2f", num);
    }

    private static int getIntFromString(String input) {
        int output;
        try{
            output = Integer.parseInt(input);
            if(output < 0) {
                output = 0;
            }
        } catch (NumberFormatException exception) {
            //TODO default behavior, should maybe fix later
            output = 0;
        }
        return output;
    }



}