package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Apple;
import model.Game;
import model.Snake;
import model.SnakeElement;

import java.util.LinkedList;

/**
 * Created by eugeny on 17.02.2016.
 */
public class GameView {
    private Game game;

    public GameView(Game game) {
        this.game = game;
    }

    public void draw(Canvas canvas) {
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

        drawSnake(canvas, cellSize);
        drawApple(canvas, cellSize);
    }

    private void drawApple(Canvas canvas, double cellSize) {
        Apple apple = game.getApple();
        if (apple==null) return;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillOval(apple.getX()*cellSize,apple.getY()*cellSize,cellSize,cellSize);
    }

    private void drawSnake(Canvas canvas, double cellSize) {
        Snake snake = game.getSnake();
        if (snake==null) return;
        SnakeElement head = snake.getHead();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.DARKGREEN);
        gc.fillOval(head.getX()*cellSize,head.getY()*cellSize,cellSize,cellSize);

        LinkedList<SnakeElement> body = snake.getBody();
        gc.setFill(Color.GREENYELLOW);
        for (SnakeElement se : body) {
            gc.fillOval(se.getX()*cellSize,se.getY()*cellSize,cellSize,cellSize);
        }
    }
}
