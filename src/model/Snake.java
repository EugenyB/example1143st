package model;

import java.util.LinkedList;

/**
 * Created by eugeny on 17.02.2016.
 */
public class Snake {
    SnakeElement head;
    LinkedList<SnakeElement> body;
    Direction dir = Direction.UP;

    public Snake(int x, int y) {
        head = new SnakeElement(x,y);
        body = new LinkedList<>();
        body.add(new SnakeElement(x-1,y));
        body.add(new SnakeElement(x-2,y));
    }

    public SnakeElement getHead() {
        return head;
    }

    public LinkedList<SnakeElement> getBody() {
        return body;
    }

    public boolean contains(GameElement element) {
        return body.contains(element) || head.equals(element);
    }

    public void move() {
        last = body.removeLast();
        body.addFirst(head);
        head = dir.next(head);
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void grow() {
        body.addLast(last);
    }

    SnakeElement last;
}
