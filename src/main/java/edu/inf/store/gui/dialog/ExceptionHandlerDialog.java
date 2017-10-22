package edu.inf.store.gui.dialog;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import edu.inf.store.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ResourceBundle;

public class ExceptionHandlerDialog {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerDialog.class);
    // ================================================================================
    // Properties
    // ================================================================================
    protected JFXDialog dialog;
    private Exception exception;

    // ================================================================================
    // Constructors
    // ================================================================================
    public ExceptionHandlerDialog(Exception exception) {
        this.exception = exception;
        StackPane dialogPane = Main.getMainController().getContent();
        dialog = new JFXDialog(dialogPane, getDialogContent(), DialogTransition.CENTER);
    }

    // ================================================================================
    // Other methods
    // ================================================================================
    public void show() {
        dialog.show();
    }

    private Region getDialogContent() {
        Region content = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/dialog/ExceptionHandlerDialog.fxml"));
            loader.setResources(getDialogBundle());
            loader.setController(new DialogController(this, exception));
            content = loader.load();
        } catch (IOException e) {
            LOGGER.error("I/O Exception", e);
        }
        return content;
    }

    protected ResourceBundle getDialogBundle() {
        return Main.getBundle();
    }

    public void closeDialog() {
        dialog.close();
    }

}
