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

public class HelloController {

    public void initialize() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0, 10, 10);
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
        System.out.println(keyEvent.getCode().toString());
    }

}