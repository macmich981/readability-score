import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] numbers = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            numbers[i] = Character.getNumericValue(str.charAt(i));
        }
        int sum = 0;
        for (int i = 0; i < str.length() / 2; i++) {
            sum += numbers[i];
        }
        int sum1 = 0;
        for (int i = str.length() / 2; i < numbers.length; i++) {
            sum1 += numbers[i];
        }

        if (sum == sum1) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}