package readability;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static String load(String filename) {
        File file = new File(filename);
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            System.out.println("Error");
        }
        return null;
    }

    public static void main(String[] args) {

        if (!args[0].isEmpty()) {
            String text = load(args[0]);
            if (text != null) {
                Statistics statistics = new Statistics(text);
                statistics.calculateStatistics();
                UserInterface userInterface = new SimpleUserInterface(statistics);
                userInterface.showStatistics();
                userInterface.selectIndex();
            }
        }
    }
}
