package com.szekalski.michal.mysnake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snake {

    private Direction direction;
    private List<Point> snakeBody;

    public Snake(Direction direction, Point point) {
        this.direction = direction;
        snakeBody = new ArrayList<>();
        snakeBody.add(point);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveSnake () {

    }

    public void eat (Point point) {

    }

    public void printSnake (Canvas canvas, GraphicsContext graphicsContext) {
//        Iterator<Point> iterator = snakeBody.listIterator();
//        while (iterator.hasNext()) {
            graphicsContext.fillRect(snakeBody.get(0).getPosX(), snakeBody.get(0).getPosY(), 10, 10);

    }

    public boolean gameOver () {

        return true; //returns true if snake reached canvas borders or crossed itself
    }

    public void generateFood () {

    }

}
