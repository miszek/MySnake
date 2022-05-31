package com.szekalski.michal.mysnake;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class HelloController {

    Snake snake;
    GraphicsContext graphicsContext;

    @FXML
    private VBox vbox;

    @FXML
    private HBox hbox;

    @FXML
    private Pane pane;

    @FXML
    private Canvas canvas;

    @FXML
    private Button startButton;

    public void initialize() {

        canvas.setHeight(HelloApplication.WINDOW_WIDTH);
        canvas.setWidth(HelloApplication.WINDOW_LENGTH);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphicsContext.setFill(Color.WHITE);
//        snake.printSnake(graphicsContext);
    }

    @FXML
    private void onKeyPressedVBox(KeyEvent keyEvent) {

        switch (keyEvent.getCode().toString()) {
            case "UP":
                if (snake.getDirection()!=Direction.DOWN) {
                    snake.setDirection(Direction.UP);
                }
                System.out.println("UP pressed");
                keyEvent.consume();
                break;
            case "LEFT":
                if (snake.getDirection()!=Direction.RIGHT) {
                    snake.setDirection(Direction.LEFT);
                }
                System.out.println("LEFT pressed");
                keyEvent.consume();
                break;
            case "RIGHT":
                if (snake.getDirection()!=Direction.LEFT) {
                    snake.setDirection(Direction.RIGHT);
                }
                System.out.println("RIGHT pressed");
                keyEvent.consume();
                break;
            case "DOWN":
                if (snake.getDirection()!=Direction.UP) {
                    snake.setDirection(Direction.DOWN);
                }
                System.out.println("DOWN pressed");
                keyEvent.consume();
                break;
        }
        System.out.println("Snake is moving: " + snake.getDirection());
    }

    public void buttonOnAction () {
        canvas.requestFocus();
        snake = new Snake(Direction.DOWN, new Point(10, 30));
//                , new Point(10, 20), new Point(10, 10), new Point(10, 0));
        clearCanvas();

        Runnable gameLoop = new Runnable() {
            @Override
            public void run() {
                snake.generateFood(graphicsContext);
                do {
                    startButton.setDisable(true);
                    snake.printSnake(graphicsContext);
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    snake.clearSnake(graphicsContext);
                    if(snake.moveSnake()) {
                        snake.generateFood(graphicsContext);
                    }
                } while(!snake.isGameOver(graphicsContext));
                startButton.setDisable(false);
                snake.printSnake(graphicsContext);
                snake.isGameOver(graphicsContext);
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