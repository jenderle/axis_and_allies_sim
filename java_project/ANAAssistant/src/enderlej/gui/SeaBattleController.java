/*
 * <TODO Course - Section>
 * <TODO Term>
 * <TODO Lab Assignment>
 * Name: enderlej
 * Created: 4/8/2017
 */
package enderlej.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * <TODO add description of the class>
 *
 * @author enderlej
 */
public class SeaBattleController {
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
     */
    @FXML
    public void initialize() {}

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
}