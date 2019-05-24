package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.Model.DatabaseManager;
import sample.Model.Dictionary;
import sample.Model.Word;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

public class NewDicController {

    @FXML
    TextField newDictionaryText;

    private DatabaseManager databaseManager = new DatabaseManager();

    public void pressCreate(ActionEvent event) {
        this.databaseManager.insertDictionary(this.newDictionaryText.getText());
        this.newDictionaryText.setText("");
    }


    public void pressBack(ActionEvent event) throws IOException {
        Stage stageMain = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loaderMain = new FXMLLoader();
        loaderMain.setLocation(getClass().getResource("../View/main.fxml"));
        AnchorPane userview = (AnchorPane) loaderMain.load();
        Scene main_scene = new Scene(userview);

        stageMain.setScene(main_scene);
        stageMain.show();
    }
}
