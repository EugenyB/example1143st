package model;

/**
 * Created by eugeny on 17.02.2016.
 */
public class Game {
    private Snake snake;
    private Apple apple;
    private int size;

    public Game() {
        size = 30;
        snake = new Snake();
//        apple = new Apple();
    }

    public int getSize() {
        return size;
    }
}
