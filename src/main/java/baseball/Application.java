package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Judger judger = new Judger();
        Human human = new Human();
        Computer computer = new Computer();

        computer.setNumbers();

        do {
            judger.startGame();
            human.setNumbers();

            judger.compareNumbers(human.getNumbers(), computer.getNumbers());
        } while (true);
    }
}
