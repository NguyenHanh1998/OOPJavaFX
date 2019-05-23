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

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Dictionary dictionary;
    private DatabaseManager databaseManager;

    @FXML
    Button closeButton;
    @FXML
    Button searchButton;
    @FXML
    Button updateButton;
    @FXML
    Button deleteButton;

    @FXML
    TextField searchText;
    @FXML
    TextField meanText;

    @FXML
    ComboBox<String> dictionaryList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // init data in here
        // gia su chay data ban dau la
        try {
            this.databaseManager = new DatabaseManager();
            this.dictionaryList.getItems().clear();
            String[] dictionaries = this.databaseManager.getDictionaries();
            for(int i = 0; i < dictionaries.length; i++) {
                this.dictionaryList.getItems().add(dictionaries[i]);
            }
            this.dictionaryList.getSelectionModel().select(0);
            this.dictionary = new Dictionary(dictionaryList.getValue());
            //this.dictionary = new Dictionary(this.dictionaryList.getValue());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error alert");
            alert.setHeaderText("Error");
            alert.setContentText("This dictionary does not exists!");

            alert.showAndWait();
        }
    }

    @FXML
    public void closeEvent(ActionEvent actionEvent) {
        System.exit(1);
    }

    public void updateEvent(ActionEvent actionEvent) {
        this.dictionary.updateMean(this.searchText.getText(), this.meanText.getText());
    }

    public void deleteEvent(ActionEvent actionEvent) {
        try {
            this.dictionary.deleteWord(this.searchText.getText());
            this.searchText.setText("");
            this.meanText.setText("");
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error alert");
            alert.setHeaderText("Error");
            alert.setContentText("This word does not exists!");

            alert.showAndWait();
        }
    }

    public void searchEvent(ActionEvent actionEvent) {
        try {
            Word word = this.dictionary.search(this.searchText.getText());
            this.meanText.setText(word.getMean());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error alert");
            alert.setHeaderText("Error");
            alert.setContentText("This word does not exists!");

            alert.showAndWait();
        }
    }

    public void changeDictEvent(ActionEvent actionEvent) {
        this.dictionary = new Dictionary(this.dictionaryList.getValue());
    }
}
