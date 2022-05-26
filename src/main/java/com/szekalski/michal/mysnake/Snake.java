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


        for (int i = 0; i < snakeBody.size()-1; i++) {
            snakeBody.get(i).setPosX(snakeBody.get(i+1).getPosX());
            snakeBody.get(i).setPosY(snakeBody.get(i+1).getPosY());
        }
        snakeBody.get(snakeBody.size()-1).setPosX(snakeBody.get(snakeBody.size()-1).getPosX()+10);
        snakeBody.get(snakeBody.size()-1).setPosY(snakeBody.get(snakeBody.size()-1).getPosY()+10);
    }
    public void eat (Point point) {

    }

    public void printSnake (GraphicsContext graphicsContext) {
        for (Point p : snakeBody) {
            graphicsContext.fillRect(p.getPosX(), p.getPosY(), 10, 10);
        }
    }

    public boolean gameOver () {

        return true; //returns true if snake reached canvas borders or crossed itself
    }

    public void generateFood () {

    }

}
