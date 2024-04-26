package com.zyzz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ZYZZController implements Initializable{

    @FXML
    private Button testYourMasculinity;


    private Stage stage;
    public void setStage(Stage stage){
        this.stage = stage;
    }



    @FXML
    public void openLoadingBar() throws IOException {

        this.stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ZYZZController.class.getResource("loadingBar.fxml"));
        Parent root = fxmlLoader.load();
        LoadingBarController loadingBarController = fxmlLoader.getController();
        Stage loadingBar = new Stage();
        loadingBarController.setStage(loadingBar);
        Scene scene = new Scene(root);
        loadingBar.setResizable(false);
        ImageView icon = new ImageView(new Image("zyzz.jpg"));
        loadingBar.getIcons().add(icon.getImage());
        loadingBar.setTitle("Calculating...");
        loadingBar.setScene(scene);
        loadingBar.show();
        loadingBarController.loadBar(loadingBar);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}