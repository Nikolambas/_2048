package com.example._2048;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.*;

public class Controller {

    @FXML
    private TextArea oneOne;
    @FXML
    private TextArea oneTwo;
    @FXML
    private TextArea oneThree;
    @FXML
    private TextArea oneFour;
    @FXML
    private TextArea twoOne;
    @FXML
    private TextArea twoTwo;
    @FXML
    private TextArea twoThree;
    @FXML
    private TextArea twoFour;
    @FXML
    private TextArea threeOne;
    @FXML
    private TextArea threeTwo;
    @FXML
    private TextArea threeThree;
    @FXML
    private TextArea threeFour;
    @FXML
    private TextArea fourOne;
    @FXML
    private TextArea fourTwo;
    @FXML
    private TextArea fourThree;
    @FXML
    private TextArea fourFour;
    @FXML
    private Label gameOver;
    @FXML
    private Label gameWinner;

    private NumberService numberService=new NumberService();
    private final String number = "2";
    private Map<Integer, TextArea> field;

    public void setFieldMap() {
        field = new HashMap<>();
        field.put(1, oneOne);
        field.put(2, oneTwo);
        field.put(3, oneThree);
        field.put(4, oneFour);
        field.put(5, twoOne);
        field.put(6, twoTwo);
        field.put(7, twoThree);
        field.put(8, twoFour);
        field.put(9, threeOne);
        field.put(10, threeTwo);
        field.put(11, threeThree);
        field.put(12, threeFour);
        field.put(13, fourOne);
        field.put(14, fourTwo);
        field.put(15, fourThree);
        field.put(16, fourFour);
        if (field.values().stream().anyMatch(textArea -> textArea.getText().equals("2048"))){
            gameWinner.setVisible(true);
        }
    }

    public void restartField() {
        setFieldMap();
        field.values().stream().forEach(textArea -> textArea.setText(""));
    }


    public void getRandomNumber() {
        if (ifGameEnd()) {
            boolean ok = true;
            while (ok) {
                Random random = new Random();
                int numb = random.nextInt(16);
                if (numb == 0) {
                    numb = 16;
                }
                if (field.get(numb).getText().equals("")) {
                    field.get(numb).setText(number);
                    ok = false;
                }
            }
        }
    }

    public boolean ifGameEnd() {
        if (field.values().stream().filter(textArea -> textArea.getText().equals("")).findFirst().isEmpty()) {
            gameOver.setVisible(true);
            return false;
        }
        return true;
    }

    public void getFieldLeft() {
        setFieldMap();
        numberService.moveNumber(oneOne,oneTwo,oneThree,oneFour);
        numberService.moveNumber(twoOne,twoTwo,twoThree,twoFour);
        numberService.moveNumber(threeOne,threeTwo,threeThree,threeFour);
        numberService.moveNumber(fourOne,fourTwo,fourThree,fourFour);
        getRandomNumber();
    }

    public void getFieldUp() {
        setFieldMap();
        numberService.moveNumber(oneOne,twoOne,threeOne,fourOne);
        numberService.moveNumber(oneTwo,twoTwo,threeTwo,fourTwo);
        numberService.moveNumber(oneThree,twoThree,threeThree,fourThree);
        numberService.moveNumber(oneFour,twoFour,threeFour,fourFour);
        getRandomNumber();
    }

    public void getFieldRight() {
        setFieldMap();
        numberService.moveNumber(oneFour,oneThree,oneTwo,oneOne);
        numberService.moveNumber(twoFour,twoThree,twoTwo,twoOne);
        numberService.moveNumber(threeFour,threeThree,threeTwo,threeOne);
        numberService.moveNumber(fourFour,fourThree,fourTwo,fourOne);
        getRandomNumber();
    }

    public void getFieldDown() {
        setFieldMap();
        numberService.moveNumber(fourOne,threeOne,twoOne,oneOne);
        numberService.moveNumber(fourTwo, threeTwo ,twoTwo,oneTwo);
        numberService.moveNumber(fourThree ,threeThree,twoThree,oneThree);
        numberService.moveNumber(fourFour,threeFour,twoFour,oneFour);
        getRandomNumber();
    }

    public void start(MouseEvent mouseEvent) {
        restartField();
        getRandomNumber();
    }

    public void getCode(KeyEvent event) {
        switch (event.getCode()){
            case W:
                getFieldUp();
                break;
            case S:
                getFieldDown();
                break;
            case A:
                getFieldLeft();
                break;
            case D:
                getFieldRight();
                break;
        }
    }
}