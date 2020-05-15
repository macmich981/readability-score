import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstRoot;
        double secondRoot;
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double determinant = b * b - 4 * a * c;
        double sqrt = Math.sqrt(determinant);

        if (determinant > 0) {
            firstRoot = (-b + sqrt) / (2 * a);
            secondRoot = (-b - sqrt) / (2 * a);
            System.out.println(Math.min(firstRoot, secondRoot) + " " + Math.max(firstRoot, secondRoot));
        } else if (determinant == 0) {
            System.out.println((-b + sqrt) / (2 * a));
        }
    }
}