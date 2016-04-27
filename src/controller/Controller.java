package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Direction;
import model.Game;
import view.GameView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    Timeline timeline;

    @FXML Pane centralPane;
    Game  game;
    GameView gameView;

    @FXML
    Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game();
        gameView = new GameView(game);
        canvas.widthProperty().bind(centralPane.widthProperty());
        canvas.heightProperty().bind(centralPane.heightProperty());
        canvas.heightProperty().addListener(e->repaint());
        canvas.widthProperty().addListener(e->repaint());
        timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> processTick()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        centralPane.requestFocus();
    }

    private void repaint() {
        gameView.draw(canvas);
    }

    public void doExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void drawGame(ActionEvent actionEvent) {
        gameView.draw(canvas);
    }

    public void startGame(ActionEvent actionEvent) {
        centralPane.requestFocus();
        game.startGame();
        gameView.draw(canvas);
    }

    public void processTick() {
        //centralPane.requestFocus();
        game.move();
        gameView.draw(canvas);
    }

    public void processTick(ActionEvent actionEvent) {
        processTick();
    }

    public void keyPressed(Event event) {
        KeyEvent ev = (KeyEvent) event;
        KeyCode code = ev.getCode();
        switch (code) {
            case UP: game.setSnakeDir(Direction.UP);
                System.out.println("up");
                break;
            case DOWN: game.setSnakeDir(Direction.DOWN); break;
            case LEFT: game.setSnakeDir(Direction.LEFT); break;
            case RIGHT: game.setSnakeDir(Direction.RIGHT);
                System.out.println("right");
                break;
        }
    }
}
