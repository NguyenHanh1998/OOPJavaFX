package sample.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

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

    @FXML
    public void pressAdd(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/add_word.fxml"));
        AnchorPane userview = (AnchorPane) loader.load();
        Scene function_scene = new Scene(userview);

        stage.setScene(function_scene);
        stage.show();
    }
}
