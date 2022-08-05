package com.example._2048;

import javafx.scene.control.TextArea;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        int one = createNumber(first.getText());
        int two = createNumber(second.getText());
        int three = createNumber(third.getText());
        int four = createNumber(fours.getText());
        List<Integer> number = Arrays.asList(one, two, three, four);
        if (number.stream().noneMatch(integer -> integer == 0)) {
            System.out.println("all");
            sumInt(first, second);
            sumZeroAndInt(second, third);
            sumInt(second, third);
            sumZeroAndInt(third, fours);
            sumInt(third, fours);
        }
        if (one == 0 && two == 0 && three == 0) {
            sumZeroAndInt(first, fours);
        }
        if (one != 0 && two == 0 && three == 0 && four != 0) {
            sumInt(first, third);
            sumZeroAndInt(second, fours);
        }
    }

}
