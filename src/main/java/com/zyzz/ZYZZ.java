package com.zyzz;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ZYZZ extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZYZZ.class.getResource("zyzz.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        ZYZZController zyzzController = fxmlLoader.getController();
        zyzzController.setStage(stage);

        stage.setTitle("ARE YOU A REAL MAN??");
        stage.setResizable(false);
        ImageView icon = new ImageView(new Image("zyzz.jpg"));
        stage.getIcons().add(icon.getImage());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}