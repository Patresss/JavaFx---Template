package edu.inf.store;

import com.jfoenix.controls.JFXDecorator;
import edu.inf.store.gui.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private final static String TITTLE = "App Store";
    private final static int SCENE_WIDTH = 1000;
    private final static int SCENE_HEIGHT = 700;
    private static ResourceBundle bundle = ResourceBundle.getBundle("language/Bundle", new Locale("pl"));
    private static Stage mainStage;
    private static MainController mainController;

    public static void main(String[] args) {
        launch(args);
    }

    public static ResourceBundle getBundle() {
        return bundle;
    }

    public static void setBundle(ResourceBundle bundle) {
        Main.bundle = bundle;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage mainStage) {
        Main.mainStage = mainStage;
    }

    public static String getTITTLE() {
        return TITTLE;
    }

    public static int getSceneWidth() {
        return SCENE_WIDTH;
    }

    public static int getSceneHeight() {
        return SCENE_HEIGHT;
    }

    public static MainController getMainController() {
        return mainController;
    }

    public static void setMainController(MainController mainController) {
        Main.mainController = mainController;
    }

    public void start(Stage stage) {
        try {
            mainStage = stage;
            mainStage.setTitle(TITTLE);
            mainStage.getIcons().add(new Image("/image/icon.png"));

            mainStage.setScene(createScene(loadMainPane()));

            mainStage.setMinWidth(SCENE_WIDTH);
            mainStage.setMinHeight(SCENE_HEIGHT);
            mainStage.show();

        } catch (IOException e) {
            LOGGER.error("Error in start method - I/O Exception", e);
        }
    }

    private Pane loadMainPane() throws IOException {
        final FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/Main.fxml"));
        loader.setResources(bundle);

        Pane mainPane = loader.load();
        mainController = loader.getController();
        return mainPane;
    }

    private Scene createScene(final Pane mainPane) {
        Scene scene = new Scene(new JFXDecorator(mainStage, mainPane), SCENE_WIDTH, SCENE_HEIGHT);
        setStyle(scene);
        return scene;
    }

    private void setStyle(Scene scene) {
        scene.getStylesheets().add(Main.class.getResource("/css/style_day.css").toExternalForm());
    }
}
