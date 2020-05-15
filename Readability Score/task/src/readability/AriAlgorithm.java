package readability;

public class AriAlgorithm implements CalculateAlgorithm {

    private final int chars;
    private final int words;
    private final int sentences;

    public AriAlgorithm(int chars, int words, int sentences) {
        this.chars = chars;
        this.words = words;
        this.sentences = sentences;
    }

    @Override
    public double calculateScore() {
        return 4.71 * chars / words + 0.5 * words / sentences - 21.43;
    }
}
