package readability;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

import static readability.Index.*;

public class SimpleUserInterface implements UserInterface {

    private static final DecimalFormat DF = new DecimalFormat("0.00");
    private final Statistics statistics;
    private Index index;

    public SimpleUserInterface(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public void selectIndex() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String index = scanner.next();
        index = index.toLowerCase();
        System.out.println();

        switch (index) {
            case "ari":
                this.index = ARI;
                break;
            case "smog":
                this.index = SMOG;
                break;
            case "fk":
                this.index = FK;
                break;
            case "cl":
                this.index = CL;
                break;
            default:
                this.index = ALL;
                break;
        }
        showReadAbilityScore();
    }

    @Override
    public void showStatistics() {

        System.out.println("The text is:");
        System.out.println(statistics.getText() + "\n");
        System.out.println("Words: " + statistics.getWordsQuantity());
        System.out.println("Sentences: " + statistics.getSentencesQuantity());
        System.out.println("Characters: " + statistics.getChars());
        System.out.println("Syllables: " + statistics.getSyllables());
        System.out.println("Polysyllables: " + statistics.getPolysyllables());
    }

    private void showReadAbilityScore() {

        Validator validator = new Validator();
        double score;
        String age;
        DF.setRoundingMode(RoundingMode.DOWN);

        if (index == ARI || index == ALL) {
            score = new AriAlgorithm(statistics.getChars(), statistics.getWordsQuantity(), statistics.getSentencesQuantity()).calculateScore();
            age = validator.validateScore((int) score);
            if (age != null) {
                System.out.println("Automated Readability Index: " + DF.format(score) + " (about " + age.split("-")[1] + " year olds).");
            }
        }
        if (index == FK || index == ALL) {
            score = new FkAlgorithm(statistics.getWordsQuantity(), statistics.getSentencesQuantity(), statistics.getSyllables()).calculateScore();
            age = validator.validateScore((int) score);
            if (age != null) {
                System.out.println("Flesch–Kincaid readability tests:: " + DF.format(score) + " (about " + age.split("-")[1] + " year olds).");
            }
        }
        if (index == SMOG || index == ALL) {
            score = new SmogAlgorithm(statistics.getPolysyllables(), statistics.getSentencesQuantity()).calculateScore();
            age = validator.validateScore((int) score);
            if (age != null) {
                System.out.println("Simple Measure of Gobbledygook: " + DF.format(score) + " (about " + age.split("-")[1] + " year olds).");
            }
        }
        if (index == CL || index == ALL) {
            score = new CliAlgorithm(statistics.getChars(), statistics.getWordsQuantity(), statistics.getSentencesQuantity()).calculateScore();
            age = validator.validateScore((int) score);
            if (age != null) {
                System.out.println("Coleman–Liau index:: " + DF.format(score) + " (about " + age.split("-")[1] + " year olds).");
            }
        }
    }
}
