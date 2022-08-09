import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.Style;
import java.awt.*;
import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("/view/SplashForm.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

    }
}
