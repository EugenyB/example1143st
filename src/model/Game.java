package model;

import javafx.scene.control.Alert;

import java.util.Random;

/**
 * Created by eugeny on 17.02.2016.
 */
public class Game {
    private Snake snake;
    private Apple apple;
    private int size;
    private Random random = new Random();

    public Game() {
        size = 30;
    }

    public void startGame() {
        snake = new Snake(size/2, size/2);
        apple = createApple();
    }

    private Apple createApple() {
        do {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            Apple a = new Apple(x, y);
            if (!snake.contains(a)) {
                return a;
            }
        } while (true);
    }

    public int getSize() {
        return size;
    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }

    public void move() {
        if (snake!=null) {
            snake.move();
            if (snake.getHead().equals(apple)) {
                snake.grow();
                apple = createApple();
            }
            if (snake.getHead().getX()<0 || snake.getHead().getY()<0 ||
                    snake.getHead().getX()>=size || snake.getHead().getY()>=size ||
                    snake.getBody().contains(snake.getHead())) {
                int points = snake.getBody().size();
                snake = null;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Игра окончена");
                alert.setContentText("Points: " + points);
                alert.setHeaderText(null);
                alert.show();
            }
        }
    }

    public void setSnakeDir(Direction direction) {
        snake.setDir(direction);
    }
}
