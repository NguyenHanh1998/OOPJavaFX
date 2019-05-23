package sample.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Model.Dictionary;
import sample.Model.Word;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Dictionary dictionary;

    @FXML
    Button closeButton;
    @FXML
    Button searchButton;
    @FXML
    Button deleteButton;
    @FXML
    TextField searchText;
    @FXML
    TextField meanText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // init data in here
        // gia su chay data ban dau la 1
        this.dictionary = new Dictionary("Anh-Viet");
    }

    @FXML
    public void closeEvent(ActionEvent actionEvent) {
        System.exit(1);
    }

    public void searchEvent(ActionEvent actionEvent) {
        Word result = this.dictionary.search(searchText.getText());
        try {
            this.meanText.setText(result.getMean());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Not found");
            alert.setHeaderText("Cannot find this word");
            alert.setContentText("This word doesn't exist");

            alert.showAndWait();
        }
    }

    public void updateEvent(ActionEvent actionEvent) {
        String word = this.searchText.getText();
        String mean = this.meanText.getText();
        this.dictionary.updateMean(word, mean);
    }

    public void deleteEvent(ActionEvent actionEvent) {
        String word = this.searchText.getText();
        try {
            this.dictionary.deleteWord(word);
            this.searchText.setText("");
            this.meanText.setText("");
        } catch (Exception e) {

        }
    }
}
