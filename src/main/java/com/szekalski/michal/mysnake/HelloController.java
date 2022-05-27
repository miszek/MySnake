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

    Snake snake = new Snake(Direction.DOWN, new Point(0, 0));
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
    }

    public void buttonOnAction () {
        canvas.requestFocus();

        Runnable gameLoop = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
//                    System.out.println("game loop started " + i);
                    startButton.setDisable(true);
//                    clearCanvas();
                    snake.printSnake(graphicsContext);
                    snake.generateFood(graphicsContext);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    snake.clearSnake(graphicsContext);
                    snake.moveSnake();
                }
                startButton.setDisable(false);
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