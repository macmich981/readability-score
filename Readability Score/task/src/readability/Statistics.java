package readability;

public class Statistics {

    private final String text;
    private int wordsQuantity;
    private int sentencesQuantity;
    private int chars;
    private int syllables;
    private int polysyllables;

    public Statistics(String text) {
        this.text = text;
    }

    private int countSyllables(String word) {
        String vowels = "aeiouy";

        int syllables = 0;
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (i == word.length() - 1 && word.charAt(i) == 'e') {
                break; // if last char is 'e' it is not counted
            }
            // the below if else ensure more than one consecutive vowels are counted as one syllable
            if (vowels.indexOf(currentChar) >= 0) {
                if (!flag) {
                    syllables++;
                }
                flag = true;
            } else {
                flag = false;
            }
        }
        return Math.max(syllables, 1);
    }

    public void calculateStatistics() {
        String[] words = text.split(" ");
        String[] sentences = text.split("[.?!]");
        wordsQuantity = words.length;
        sentencesQuantity = sentences.length;

        for (int i = 0; i < text.length(); i++) {
            if (!Character.isWhitespace(text.charAt(i))) {
                chars++;
            }
        }
        for (String word : words) {
            syllables += countSyllables(word);
            if (countSyllables(word) > 2) {
                polysyllables++;
            }
        }
    }

    public String getText() {
        return text;
    }

    public int getWordsQuantity() {
        return wordsQuantity;
    }

    public int getSentencesQuantity() {
        return sentencesQuantity;
    }

    public int getChars() {
        return chars;
    }

    public int getSyllables() {
        return syllables;
    }

    public int getPolysyllables() {
        return polysyllables;
    }
}
