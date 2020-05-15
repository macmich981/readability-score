package readability;

public class SmogAlgorithm implements CalculateAlgorithm {

    private final int polysyllables;
    private final int sentences;

    public SmogAlgorithm(int polysyllables, int sentences) {
        this.polysyllables = polysyllables;
        this.sentences = sentences;
    }

    @Override
    public double calculateScore() {
        return 1.043 * Math.sqrt(polysyllables * 30.0 / sentences) + 3.1291;
    }
}
