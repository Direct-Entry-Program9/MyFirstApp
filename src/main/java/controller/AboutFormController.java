package controller;

import javafx.animation.FadeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class AboutFormController {
    public AnchorPane anchrContainer;

    public void initialize(){
        FadeTransition ft = new FadeTransition(Duration.millis(750), anchrContainer);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.playFromStart();
    }
}
