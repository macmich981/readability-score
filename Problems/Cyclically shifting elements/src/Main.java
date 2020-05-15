import java.util.Scanner;

class Main {

    private static void shift(int[] numbers) {
        int last = numbers[numbers.length - 1];
        int first = numbers[0];
        int temp;

        for (int i = 0; i < numbers.length; i++) {
            if (i + 1 < numbers.length) {
                temp = numbers[i + 1];
                numbers[i + 1] = first;
                first = temp;
            } else {
                numbers[0] = last;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[scanner.nextInt()];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        shift(numbers);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}