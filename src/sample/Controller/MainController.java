package sample.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    Button close;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // init data in here
        // gia su chay data ban dau la
    }

    @FXML
    public void closeEvent(ActionEvent actionEvent) {
        System.exit(1);
    }
}
