package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Model.CurrentDictionary;
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

public class AddWordController implements Initializable {
    private Dictionary dictionary;

    @FXML
    TextField customWordText;
    @FXML
    TextArea customMeanText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dictionary = new Dictionary(CurrentDictionary.getCurrentDictionaryName());
    }

    public void pressAddDB(ActionEvent event) {
        String word = this.customWordText.getText();
        String mean = this.customMeanText.getText();

        this.dictionary.insertWord(word, mean);
        this.customMeanText.setText("");
        this.customWordText.setText("");
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
