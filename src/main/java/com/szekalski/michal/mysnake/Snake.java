package com.szekalski.michal.mysnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.*;

public class Snake {
    private Direction direction;
    private List<Point> snakeBody;
    private Point food;

    public Snake(Direction direction, Point point/*, Point point2, Point point3, Point point4*/) {
        this.direction = direction;
        snakeBody = new ArrayList<>();
        snakeBody.add(point);
//        snakeBody.add(point2);
//        snakeBody.add(point3);
//        snakeBody.add(point4);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean moveSnake () {
//        System.out.println("snake is moving: " + direction);
        int x=0;
        int y=0;

        switch(direction) {
            case UP:
                x=0;
                y=-10;
                break;
            case DOWN:
                x=0;
                y=10;
                break;
            case RIGHT:
                x=10;
                y=0;
                break;
            case LEFT:
                x=-10;
                y=0;
                break;
        }

        Point nextPoint = new Point(snakeBody.get(snakeBody.size()-1).getPosX()+x,snakeBody.get(snakeBody.size()-1).getPosY()+y);

        if (nextPoint.equals(food)) {
            snakeBody.add(food);
            System.out.println("Length of the snake is: " + snakeBody.size());
            return true;
        } else {
            for (int i = 0; i < snakeBody.size()-1; i++) {
                snakeBody.get(i).setPosX(snakeBody.get(i+1).getPosX());
                snakeBody.get(i).setPosY(snakeBody.get(i+1).getPosY());
            }
            snakeBody.get(snakeBody.size()-1).setPosX(snakeBody.get(snakeBody.size()-1).getPosX()+x);
            snakeBody.get(snakeBody.size()-1).setPosY(snakeBody.get(snakeBody.size()-1).getPosY()+y);
            return false;
        }


    }

    public void printSnake (GraphicsContext graphicsContext) {
        for (Point p : snakeBody) {
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.fillRect(p.getPosX(), p.getPosY(), 10, 10);
        }
    }

    public boolean isGameOver(GraphicsContext graphicsContext) {
        Set<Point> set = new HashSet<>(snakeBody);
        if (set.size()!=snakeBody.size()) {
            System.out.println("snake collision");
            printGameOver(graphicsContext);
            return true;
        }

        if(snakeBody.get(snakeBody.size()-1).getPosX()>=HelloApplication.WINDOW_LENGTH
                || snakeBody.get(snakeBody.size()-1).getPosY()>=HelloApplication.WINDOW_WIDTH
                || snakeBody.get(snakeBody.size()-1).getPosX()<0 || snakeBody.get(snakeBody.size()-1).getPosY()<0) {
            System.out.println("snake out of canvas");
            printGameOver(graphicsContext);
            return true;
        }

        return false; //returns true if snake reached canvas borders or crossed itself
    }

    private void printGameOver(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(Color.RED);
        graphicsContext.setFont(new Font("times new roman", HelloApplication.WINDOW_LENGTH/10));
        graphicsContext.strokeText("GAME OVER", HelloApplication.WINDOW_LENGTH/5,HelloApplication.WINDOW_WIDTH/2);
    }

    public void generateFood (GraphicsContext graphicsContext) {
        Random random = new Random();
        do {
            food = new Point((random.nextInt((HelloApplication.WINDOW_LENGTH - 10) / 10) * 10) ,
                    random.nextInt((HelloApplication.WINDOW_WIDTH - 10) / 10) * 10);

        } while (checkCollision(food));
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(food.getPosX(), food.getPosY(), 10, 10);
    }

    public boolean checkCollision (Point point) {
        if (snakeBody.contains(point)) {
            return true;
        }
        return false;
    }

    public void clearSnake (GraphicsContext graphicsContext) {
        for (Point p : snakeBody) {
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillRect(p.getPosX(), p.getPosY(), 10, 10);
        }
    }
}
