package com.example.numplay;

public class BaseballGameDisplay {
    public void displayHint (int strike, int ball){
        if (strike==0 && ball==0) {
            System.out.println("아웃");
        } else if (strike==0) {
            System.out.println(ball + "볼");
        } else if (ball==0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(strike + "스트라이크 "+ ball + "볼");
        }
    }
}
