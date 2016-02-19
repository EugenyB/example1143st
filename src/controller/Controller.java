package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import model.Game;
import view.GameView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    Game  game;
    GameView gameView;

    @FXML
    Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game();
        gameView = new GameView(game);
    }

    public void doExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void drawGame(ActionEvent actionEvent) {
        gameView.draw(game, canvas);
    }
}
