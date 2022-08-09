package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;

public class MainFormController {
    public MenuItem mnuAbout;
    public MenuItem mnuNew;
    public MenuItem mnuClose;
    public AnchorPane anchrContainer;
    public MenuItem mnuOpen;
    public MenuItem mnuSave;
    public HTMLEditor txtEditor;
    public MenuItem mnuPrint;
    public MenuItem mnuPaste;
    public MenuItem mnuCopy;
    public MenuItem mnuCut;
    public MenuItem mnuSelectAll;
    public MenuItem mnuUndo;

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

    public void mnuOpenOnAction(ActionEvent actionEvent) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt Files (*.dep9)", "*.dep9"));
        File file = fileChooser.showOpenDialog(anchrContainer.getScene().getWindow());

        if (file==null){
            return;
        }

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);


        StringBuilder sb = new StringBuilder();
        while (true) {
            byte[] buffer = new byte[1024 * 10];
            int read = bis.read(buffer);
            if (read==-1) break;
            for (int i = 0; i < read; i++) {
                char readChar = (char) ~buffer[i];
                sb.append(readChar);
            }
        }

        txtEditor.setHtmlText(String.valueOf(sb));

        bis.close();

    }

    public void mnuSaveOnAction(ActionEvent actionEvent) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setInitialFileName("text.dep9");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT File (*.dep9)","*.dep9"));
        File file = fileChooser.showSaveDialog(anchrContainer.getScene().getWindow());

        if (file==null){
            return;
        }

        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        String htmlText = txtEditor.getHtmlText();
        char[] chars = htmlText.toCharArray();
        for (char aChar : chars) {
            int write = aChar;
            bos.write(~write);
        }

        bos.close();

    }

    public void mnuNewOnAction(ActionEvent actionEvent) {

        txtEditor.setHtmlText("");

    }

    public void mnuPrintOnAction(ActionEvent actionEvent) {

        if (Printer.defaultPrinterProperty()==null){
            new Alert(Alert.AlertType.ERROR,"No Default Printer").show();
        }

        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null){
            printerJob.showPageSetupDialog(anchrContainer.getScene().getWindow());
            boolean success = printerJob.printPage(txtEditor);
            if (success){
                printerJob.endJob();
            }else {
                new Alert(Alert.AlertType.ERROR,"Failed to print. Try Again").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to initialize printer job").show();
        }

    }

    public void mnuPasteOnAction(ActionEvent actionEvent) {
    }

    public void mnuCopyOnAction(ActionEvent actionEvent) {
    }

    public void mnuSelectAllOnAction(ActionEvent actionEvent) {

    }

    public void mnuCutOnAction(ActionEvent actionEvent) {
    }

    public void mnuUndoOnAction(ActionEvent actionEvent) {
    }
}
