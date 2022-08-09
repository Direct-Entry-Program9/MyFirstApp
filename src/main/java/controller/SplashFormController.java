package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SplashFormController {
    public Label lblLoadingText;

    public void initialize(){
        Timeline timeline = new Timeline();
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoadingText.setText("SetUp initialize...");
            }
        });
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoadingText.setText("Loading UI...");
            }
        });
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoadingText.setText("Plugin Build up...");
            }
        });
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(3500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoadingText.setText("Wait for a while...");
            }
        });
        KeyFrame keyFrame5 = new KeyFrame(Duration.millis(4000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoadingText.setText("Complete...");
            }
        });
        KeyFrame keyFrame6 = new KeyFrame(Duration.millis(4100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent parent = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = new Stage();
                    stage.setTitle("Text Editor");
                    stage.setScene(scene);
                    stage.show();
                    stage.setMaximized(true);
                    lblLoadingText.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4,keyFrame5,keyFrame6);
        timeline.playFromStart();

    }
}
