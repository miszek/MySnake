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

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class HelloController {

    Snake snake;
    GraphicsContext graphicsContext;
    Set<HighScoreItem> scoreSet = new HashSet<>();

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

        Point[] points = {new Point(10, 20), new Point(10, 30), new Point(10, 40)};
        snake = new Snake(Direction.DOWN, points);
        snake.printSnake(graphicsContext);
        snake.scoreCount(graphicsContext);
    }

    @FXML
    private void onKeyPressedVBox(KeyEvent keyEvent) {

        switch (keyEvent.getCode().toString()) {
            case "UP":
                if (snake!=null && snake.getDirection()!=Direction.DOWN) {
                    snake.setDirection(Direction.UP);
                }
//                System.out.println("UP pressed");
                keyEvent.consume();
                break;
            case "LEFT":
                if (snake!=null && snake.getDirection()!=Direction.RIGHT) {
                    snake.setDirection(Direction.LEFT);
                }
//                System.out.println("LEFT pressed");
                keyEvent.consume();
                break;
            case "RIGHT":
                if (snake!=null && snake.getDirection()!=Direction.LEFT) {
                    snake.setDirection(Direction.RIGHT);
                }
//                System.out.println("RIGHT pressed");
                keyEvent.consume();
                break;
            case "DOWN":
                if (snake!=null && snake.getDirection()!=Direction.UP) {
                    snake.setDirection(Direction.DOWN);
                }
//                System.out.println("DOWN pressed");
                keyEvent.consume();
                break;
        }
//        System.out.println("Snake is moving: " + snake.getDirection());
    }

    public void buttonOnAction () {
        canvas.requestFocus();
        Point[] points = {new Point(10, 20), new Point(10, 30), new Point(10, 40)};
        snake = new Snake(Direction.DOWN, points);
        clearCanvas();

        Runnable gameLoop = new Runnable() {
            @Override
            public void run() {
                snake.generateFood(graphicsContext);
                snake.scoreCount(graphicsContext);
                do {
                    snake.scoreCount(graphicsContext);
                    startButton.setDisable(true);
                    snake.printSnake(graphicsContext);
                    try {
                        Thread.sleep(70);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    snake.clearSnake(graphicsContext);
                    if(snake.moveSnake()) {
                        snake.generateFood(graphicsContext);
                    }
//                    snake.scoreCount(graphicsContext);
                } while(!snake.isGameOver(graphicsContext));
                startButton.setDisable(false);
                snake.printSnake(graphicsContext);
                scoreSet.add(new HighScoreItem(snake.scoreCount(graphicsContext), LocalDate.now()));
                printScoreList();
                try {
                    HighScore.getInstance().saveHighScore(scoreSet);
                } catch (IOException e) {
                    e.printStackTrace();
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

    public void printScoreList() {
        for (HighScoreItem hsi : scoreSet) {
            System.out.println(hsi.toString());
        }
    }

}