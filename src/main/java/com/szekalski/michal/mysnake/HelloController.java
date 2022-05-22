package com.szekalski.michal.mysnake;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class HelloController {

//    private static String direction = "DOWN";
//    Point point = new Point(0,0);
//    GraphicsContext graphicsContext;
    @FXML
    private VBox vbox;

    @FXML
    private HBox hbox;

    @FXML
    private Pane pane;

    @FXML
    private Canvas canvas;

    Snake snake = new Snake(Direction.DOWN, new Point(20,20));
    GraphicsContext graphicsContext;

    public void initialize() {

        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphicsContext.setFill(Color.WHITE);
//        graphicsContext.fillRect(point.getPosX(), point.getPosY(), 10, 10);
        canvas.requestFocus();
//        snake.printSnake(canvas);
//        snake.generateFood();

        for (int i =0; i < 10; i++) {
            snake.moveSnake();
            snake.printSnake(canvas, graphicsContext);
//            snake.eat();
        }

    }



    @FXML
    private void onKeyPressedVBox(KeyEvent keyEvent) {
//        direction = keyEvent.getCode().toString();
//        moveSnake(direction);
//        System.out.println("Direction: " + direction);

        switch (keyEvent.getCode().toString()) {
            case "UP":
                snake.setDirection(Direction.UP);
            break;
            case "DOWN":
                snake.setDirection(Direction.DOWN);
            break;
            case "LEFT":
                snake.setDirection(Direction.LEFT);;
            break;
            case "RIGHT":
                snake.setDirection(Direction.RIGHT);
            break;
        }
    }

//    public void moveSnake(String direction) {
//        graphicsContext = canvas.getGraphicsContext2D();
//        graphicsContext.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
//        graphicsContext.setFill(Color.BLACK);
//        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
//        graphicsContext.setFill(Color.WHITE);
//
//        switch (direction) {
//            case "UP":
//                if((point.getPosY()-10)>=0) {
//                    point.setPosY(point.getPosY()-10);
//                }
//                else {
//                    printGameOver();
//                }
//                break;
//            case "DOWN":
//                if((point.getPosY()+10 <= canvas.getHeight()-10)) {
//                    point.setPosY(point.getPosY()+10);
//                }
//                else {
//                    printGameOver();
//                }
//                break;
//            case "LEFT":
//                if ((point.getPosX()-10) >= 0) {
//                    point.setPosX(point.getPosX()-10);
//                }
//                else {
//                    printGameOver();
//                }
//                break;
//            case "RIGHT":
//                if((point.getPosX()+10 <= canvas.getWidth()-10)) {
//                    point.setPosX(point.getPosX() + 10);
//                }
//                else
//                {
//                    printGameOver();
//                }
//                break;
//        }
//        graphicsContext.setFill(Color.WHITE);
//        graphicsContext.fillRect(point.getPosX(), point.getPosY(), 10,10);
//    }
//
//    private void printGameOver() {
//        graphicsContext = canvas.getGraphicsContext2D();
//        graphicsContext.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
//        graphicsContext.setFill(Color.BLACK);
//        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
//        graphicsContext.setFill(Color.RED);
//        graphicsContext.fillText("GAME OVER",Math.round(canvas.getWidth()/2-20),
//                Math.round(canvas.getHeight()/2));
//    }
//
//    public void startButtonOnAction() {
//
//    }
}