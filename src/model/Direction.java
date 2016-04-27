package model;

/**
 * Created by eugeny on 13.04.2016.
 */
public interface Direction {
    SnakeElement next(SnakeElement head);
    Direction UP = h -> new SnakeElement(h.getX(), h.getY()-1);
    Direction DOWN = h -> new SnakeElement(h.getX(), h.getY()+1);
    Direction LEFT = h -> new SnakeElement(h.getX()-1, h.getY());
    Direction RIGHT = h -> new SnakeElement(h.getX()+1, h.getY());
}
