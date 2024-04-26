package com.zyzz;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoadingBarController implements Initializable {

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label textLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progressBar.setStyle("-fx-accent: #00FF00");
        progressBar.setProgress(0);
    }

    private Stage stage;
    public void setStage(Stage stage){
        this.stage = stage;
    }

    public int getRandomNumber(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    class LoadProgressBarThread extends Thread {

        private Stage stage;
        private Label textLabel;

        public LoadProgressBarThread(Stage stage, Label textLabel) {
            this.stage = stage;
            this.textLabel = textLabel;
        }

        public void run(){
            for (double i = 0; i <= 1; i += 0.005) {
                progressBar.setProgress(i);
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(i >= 0.249 && i <= 0.251){
                    Platform.runLater(()->textLabel.setText("Calculating...."));
                }
                else if(i >= 0.499 && i <= 0.501){
                    Platform.runLater(()->textLabel.setText("Checking the lists"));
                }
                else if(i >= 0.75){
                    Platform.runLater(()->textLabel.setText("Almost done...."));
                }
            }
            Platform.runLater(()->{
                this.stage.close();
                int randomNumber = getRandomNumber(2);
                if(randomNumber == 0){
                    FalseMasculineController falseMasculineController = new FalseMasculineController();
                    try {
                        falseMasculineController.start();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    TrueMasculineController trueMasculineController = new TrueMasculineController();
                    try {
                        trueMasculineController.start();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }



    @FXML
    public void loadBar(Stage stage) throws IOException {
        LoadProgressBarThread progressBarThread = new LoadProgressBarThread(stage, textLabel);
        progressBarThread.start();
    }
}


