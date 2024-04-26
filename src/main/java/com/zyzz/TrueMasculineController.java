package com.zyzz;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class TrueMasculineController {

    public void start() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TrueMasculineController.class.getResource("trueMasculine.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("YOU'RE ZYZZ APPROVED!!!");
        Media media = new Media(new File("C:\\MasculinityTester\\zyzz.mp3").toURI().toString());
        MediaPlayer musicPlayer = new MediaPlayer(media);
        musicPlayer.setAutoPlay(true);
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        ImageView icon = new ImageView(new Image("zyzz.jpg"));
        stage.getIcons().add(icon.getImage());
        stage.show();
    }

}
