package baseball;

import java.util.Arrays;
import java.util.List;

public class Judger {
    private int[] score;

    public Judger() {
        this.score = new int[3];
    }

    public void compareNumbers(List<Integer> human, List<Integer> computer) {
        int[] strikeIdx = checkStrike(human, computer);
        checkBall(human, computer, strikeIdx);
        checkNothing();
        displayScoreboard();
    }

    public void displayScoreboard() {
        if(this.score[2] != 0) {
            System.out.println("낫싱");
        }
        else if(this.score[0] > 0 && this.score[1] > 0) {
            System.out.println(this.score[1] + "볼 " + this.score[0] + "스트라이크");
        }
        else if(this.score[0] > 0) {
            System.out.println(this.score[0] + "스트라이크");
        }
        else {
            System.out.println(this.score[1] + "볼");
        }
        checkGameEnd();
    }

    private int[] checkStrike(List<Integer> human, List<Integer> computer){
        int[] strikeIdx = new int[3];

        for(int i = 0; i < 3; i++) {
            if(human.get(i).equals(computer.get(i))){
                this.score[0] += 1;
                strikeIdx[i] = 1;
            }
        }

        return strikeIdx;
    }

    private void checkBall(List<Integer> human, List<Integer> computer, int[] strikeIdx){
        for(int i = 0; i < human.size(); i++) {
            if(strikeIdx[i] == 1) continue;
            if(computer.contains(human.get(i))) {
                this.score[1] += 1;
            }
        }
    }

    private void checkNothing() {
        if(this.score[0] == 0 && this.score[1] == 0){
            this.score[2] = 1;
        }
    }

    private void checkGameEnd() {
        if(this.score[0] != 3) return;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
