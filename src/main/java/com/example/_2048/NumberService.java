package com.example._2048;

import javafx.scene.control.TextArea;

public class NumberService {
    public void sum(TextArea first, TextArea second) {
        if (first.getText().equals("")) {
            first.setText(second.getText());
            second.setText("");
        }
        if (first.getText().equals(second.getText())&&!first.getText().equals("")) {
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
//        int one = createNumber(first.getText());
//        int two = createNumber(second.getText());
//        int three = createNumber(third.getText());
//        int four = createNumber(fours.getText());
        sum(first,second);
        sum(second,third);
        sum(third,fours);
    }


}
