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
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        double min = Math.min(width,height);
        int size = game.getSize();
        double cellSize = min/size;
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        for (int i = 0; i <= size; i++) {
            gc.strokeLine(0, i*cellSize, size*cellSize, i*cellSize);
        }
        for (int i = 0; i <= size; i++) {
            gc.strokeLine(i*cellSize, 0, i*cellSize, size*cellSize);
        }
    }
}
