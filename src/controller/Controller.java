package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import model.Game;
import view.GameView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

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
    }

    private void repaint() {
        gameView.draw(game, canvas);
    }

    public void doExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void drawGame(ActionEvent actionEvent) {
        gameView.draw(game, canvas);
    }
}
