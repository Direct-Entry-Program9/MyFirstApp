package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public MenuItem mnuAbout;
    public MenuItem mnuNew;
    public MenuItem mnuClose;
    public AnchorPane anchrContainer;

    public void initialize(){

        mnuClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        

        mnuAbout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/AboutForm.fxml")));
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("About Text Editor");
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
