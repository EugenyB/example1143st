package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Game;

/**
 * Created by eugeny on 17.02.2016.
 */
public class GameView {
    private Game game;

    public GameView(Game game) {
        this.game = game;
    }

    public void draw(Game game, Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.strokeRect(0,0,canvas.getWidth()/2,canvas.getHeight()/2);
    }
}
