package readability;

public class CliAlgorithm implements CalculateAlgorithm {

    private final int chars;
    private final int words;
    private final int sentences;

    public CliAlgorithm(int chars, int words, int sentences) {
        this.chars = chars;
        this.words = words;
        this.sentences = sentences;
    }

    @Override
    public double calculateScore() {
        double l = (double) chars / words * 100;
        double s = (double) sentences / words * 100;
        return 0.0588 * l - 0.296 * s - 15.8;
    }
}
