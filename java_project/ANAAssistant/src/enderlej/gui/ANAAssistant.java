/*
 * <TODO Course - Section>
 * <TODO Term>
 * <TODO Lab Assignment>
 * Name: enderlej
 * Created: 4/8/2017
 */
package enderlej.gui;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * <TODO add description of the class>
 *
 * @author enderlej
 */
public class ANAAssistant extends Application {

    private static final Logger LOGGER = Logger.getLogger(ANAAssistant.class.getName());
    private static final String LAND_TITLE = "Aide-de-camp - an Axis & Allies assistant";
    private static final String LAND_FXML = "LandBattle.fxml";

    private static final String SEA_TITLE = "Aide-de-camp - an Axis & Allies assistant";
    private static final String SEA_FXML = "SeaBattle.fxml";

    private static final String RESEARCH_TITLE = "Aide-de-Camp - research odds";
    private static final String RESEARCH_FXML = "Research.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage landStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(LAND_FXML));
            Parent landRoot = fxmlLoader.load();
            landStage.setScene(new Scene(landRoot));
            landStage.setTitle(LAND_TITLE);
            landStage.getIcons().add(new Image("ANAicon.png"));
            landStage.setOnCloseRequest(event -> Platform.exit()); // make whole program end when main stage is closed
            landStage.setResizable(false);
            landStage.sizeToScene();
            landStage.show();

            LandBattleController landController = fxmlLoader.getController();

            Stage seaStage = new Stage();
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(SEA_FXML));
            Parent seaRoot = fxmlLoader.load();
            seaStage.setScene(new Scene(seaRoot));
            seaStage.setTitle(SEA_TITLE);
            seaStage.getIcons().add(new Image("ANAicon.png"));
            seaStage.setResizable(false);

            SeaBattleController seaController = fxmlLoader.getController();


            Stage researchStage = new Stage();
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(RESEARCH_FXML));
            Parent researchRoot = fxmlLoader.load();
            researchStage.setScene(new Scene(researchRoot));
            researchStage.setTitle(RESEARCH_TITLE);
            researchStage.getIcons().add(new Image("ANAicon.png"));
            researchStage.setResizable(false);

            landController.setLandStage(landStage);
            landController.setSeaStage(seaStage);
            landController.setResearchStage(researchStage);

            seaController.setLandStage(landStage);
            seaController.setSeaStage(seaStage);
            seaController.setResearchStage(researchStage);

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
}