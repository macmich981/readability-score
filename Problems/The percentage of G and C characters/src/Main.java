import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int chars = 0;

        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g' || str.charAt(i) == 'c') {
                chars++;
            }
        }
        System.out.println((double) chars / str.length() * 100);
    }
}