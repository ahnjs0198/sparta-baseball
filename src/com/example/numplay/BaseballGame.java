package com.example.numplay;

import java.util.*;
import java.util.stream.Stream;

public class BaseballGame {
    HashSet<Integer> answerSet = new HashSet<>();
    int[] answer;
    List<Integer> answerList = new ArrayList<>();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    int count = 0;
    BaseballGameDisplay hint = new BaseballGameDisplay();


    public BaseballGame() {

    }

    public int play() {

        while(true){
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("1.게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int option = scanner2.nextInt();
            if (option==1){
                System.out.println();
                System.out.println("< 게임을 시작합니다 >");
                // 정답 answer을 설정
                answerSet.clear();
                while (answerSet.size()<3){
                    answerSet.add(random.nextInt(8) + 1);
                }
                answerList = new ArrayList<>(answerSet);
                Collections.shuffle(answerList);
                //System.out.println(answerList);
                answer = answerList.stream().mapToInt(Integer::intValue).toArray();
                while(true) {
                    // 1. 유저에게 입력값을 받음
                    System.out.println("숫자를 입력하세요");
                    String input = scanner.nextLine();
                    // 2. 올바른 입력값을 받았는지 검증
                    while(!validateInput(input)){
                        System.out.println("올바르지 않은 입력값입니다");
                        System.out.println();
                        System.out.println("숫자를 입력하세요");
                        input = scanner.nextLine();
                    }
                    // 3. 게임 진행횟수 증가
                    count++;
                    // 4. 스트라이크 개수 계산
                    int strike = countStrike(input);
                    // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
                    if (strike == 3){
                        System.out.println("정답입니다!");
                        break;
                    }
                    // 6. 볼 개수 계산
                    int ball = countBall(input);
                    // 7. 힌트 출력
                    hint.displayHint(strike, ball);
                }
            } else if (option==3){
                System.out.println("게임 종료");
                break;
            }
        }

        // 게임 진행횟수 반환
        return count;
    }

    protected boolean validateInput(String input){
        // 1부터 9사이의 숫자인지 확인
        if(input.matches("^[1-9]*$")){
            // 중복된 숫자가 없는지 확인
            int[] inputDigits = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
            for (int i=0; i<3; i++){
                for (int j=0; j<i; j++){
                    if (inputDigits[i]==inputDigits[j]){
                        return false;
                    }
                }
            }
            return true;
        } else{
            return false;
        }
    }

    private int countStrike(String input){
        int[] inputDigits = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        // 같은 숫자 같은 자리가 있는지 확인
        for (int i=0; i<3; i++){
            if (inputDigits[i]==answer[i]){
                count++;
            }
        }
        return count;
    }

    private int countBall(String input){
        int[] inputDigits = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        // 같은 숫자 다른 자리가 있는지 확인
        for (int i=0; i<3; i++){
            for (int j=0; j<i; j++){
                if(inputDigits[i]==answer[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
