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

    Snake snake = new Snake(Direction.DOWN, new Point(20, 20));
    GraphicsContext graphicsContext;

    @FXML
    private VBox vbox;

    @FXML
    private HBox hbox;

    @FXML
    private Pane pane;

    @FXML
    private Canvas canvas;


    public void initialize() {

        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphicsContext.setFill(Color.WHITE);
//        graphicsContext.fillRect(point.getPosX(), point.getPosY(), 10, 10);
//        canvas.requestFocus();
//
//        }
    }



    @FXML
    private void onKeyPressedVBox(KeyEvent keyEvent) {

        switch (keyEvent.getCode().toString()) {
            case "UP":
                snake.setDirection(Direction.UP);
                System.out.println("UP pressed");
            break;
            case "DOWN":
                snake.setDirection(Direction.DOWN);
                System.out.println("DOWN pressed");
                break;
            case "LEFT":
                snake.setDirection(Direction.LEFT);;
                System.out.println("LEFT pressed");
                break;
            case "RIGHT":
                snake.setDirection(Direction.RIGHT);
                System.out.println("RIGHT pressed");
                break;
        }
    }


    public void buttonOnAction () {
        canvas.requestFocus();

        Runnable gameLoop = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
//                    System.out.println("game loop started " + i);
                    clearCanvas();
                    snake.printSnake(graphicsContext);
                    snake.moveSnake();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(gameLoop).start();
    }

    public void clearCanvas () {
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }


}