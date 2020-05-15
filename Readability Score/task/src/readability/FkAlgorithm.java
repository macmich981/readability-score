package readability;

public class FkAlgorithm implements CalculateAlgorithm {

    private final int words;
    private final int sentences;
    private final int syllables;

    public FkAlgorithm(int words, int sentences, int syllables) {
        this.words = words;
        this.sentences = sentences;
        this.syllables = syllables;
    }

    @Override
    public double calculateScore() {
        return 0.39 * ((double) words / sentences) + 11.8 * ((double) syllables / words) - 15.59;
    }
}
