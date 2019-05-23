package sample.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController {

    private Stage stage;

    @FXML
    Button btn_Custom_Dic;

    public void pressEVDic(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/functions.fxml"));
        try {
            Parent userview = loader.load();
            Scene scene = new Scene(userview, 800, 600);
            stage.setScene(scene);
        } catch (IOException e) {
            System.out.println(e.getMessage());// phai load truoc moi duoc goi getController
        }
        //SortViewController sortController =((SortViewController) loader.getController());
    }

    public void pressVEDic(ActionEvent event){}
    public void pressCustomDic()throws Exception{
        stage = (Stage) btn_Custom_Dic.getScene().getWindow();
        BorderPane root;
        root = (BorderPane) FXMLLoader.load(getClass().getResource("functions.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        System.out.println("button custom clicked");
    }

}
