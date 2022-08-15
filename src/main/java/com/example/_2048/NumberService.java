package com.example._2048;

import javafx.scene.control.TextArea;


public class NumberService {
    public void sumZeroAndInt(TextArea first, TextArea second) {
        if (first.getText().equals("")) {
            first.setText(second.getText());
            second.setText("");
        }
    }

    public void sumInt(TextArea first, TextArea second) {
        if (first.getText().equals(second.getText()) && !first.getText().equals("")) {
            int one = createNumber(first.getText());
            int two = createNumber(second.getText());
            int sum = one + two;
            first.setText(sum + "");
            second.setText("");
        }
    }

    public int createNumber(String s) {
        if (s.equals("")) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    public void moveNumber(TextArea first, TextArea second, TextArea third, TextArea fours) {
        sumZeroAndInt(third, fours);
        sumInt(third, fours);
        sumZeroAndInt(second, third);
        sumInt(second, third);
        sumZeroAndInt(first,second);
        sumInt(first,second);
        sumZeroAndInt(third, fours);
        sumZeroAndInt(second, third);
        sumZeroAndInt(first,second);

    }

}
