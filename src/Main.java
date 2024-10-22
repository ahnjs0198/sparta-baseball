import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] inputDigits = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.toString(inputDigits));
    }
}