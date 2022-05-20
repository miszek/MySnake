package com.szekalski.michal.mysnake;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;
import java.util.function.ToDoubleBiFunction;

public class HelloController {

    Point point = new Point(0,0);
    GraphicsContext graphicsContext;

    public void initialize() {

        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(point.getPosX(), point.getPosY(), 10, 10);
        canvas.requestFocus();
    }

    @FXML
    private VBox vbox;

    @FXML
    private Pane pane;

    @FXML
    private Canvas canvas;

    @FXML
    private void redrawCanvas() {
//        canvas.setWidth(pane.getWidth());
//        canvas.setHeight(pane.getHeight());
    }

    @FXML
    private void onKeyPressedVBox(KeyEvent keyEvent) {
                movePoint(keyEvent.getCode().toString());
//        switch (keyEvent.getCode()) {
//            case UP:
//                movePoint("UP");
//                break;
//            case DOWN:
//                movePoint("DOWN");
//                break;
//            case RIGHT:
//                movePoint("RIGHT");
//                break;
//            case LEFT:
//                movePoint("LEFT");
//
//        }
    }

    public void movePoint (String direction) {
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0,0,240,320);

        switch (direction) {
            case "UP":
                point.setPosY(point.getPosY()-10);
                break;
            case "DOWN":
                point.setPosY(point.getPosY()+10);
                break;
            case "RIGHT":
                point.setPosX(point.getPosX()+10);
                break;
            case "LEFT":
                point.setPosX(point.getPosX()-10);
                break;


        }

        graphicsContext.fillRect(point.getPosX(), point.getPosY(), 10,10);
    }

}