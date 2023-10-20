package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public List<Integer> inputNumbers() {
        String numString = Console.readLine();
        List<Integer> numbers = Arrays.stream(numString.split("")).map(Integer::parseInt).toList();
        validate(numbers);
        return numbers;
    }

    public int inputNumber() {
        int number = Integer.parseInt(Console.readLine());
        validate(number);
        return number;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.contains(0)) {
            throw new IllegalArgumentException();
        }
        if(set.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(int number) {
        if(number != 1 && number != 2) {
            throw new IllegalArgumentException();
        }
    }
}
