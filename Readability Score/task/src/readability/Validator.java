package readability;

import java.util.HashMap;
import java.util.Map;

public class Validator {

    private static Map<Integer, String> initReadIndex() {
        Map<Integer, String> index = new HashMap<>();

        index.put(1, "5-6");
        index.put(2, "6-7");
        index.put(3, "7-9");
        index.put(4, "9-10");
        index.put(5, "10-11");
        index.put(6, "11-12");
        index.put(7, "12-13");
        index.put(8, "13-14");
        index.put(9, "14-15");
        index.put(10, "15-16");
        index.put(11, "16-17");
        index.put(12, "17-18");
        index.put(13, "18-24");
        index.put(14, "-24+");
        return new HashMap<>(index);
    }

    public String validateScore(int score) {

        if (initReadIndex().containsKey(score)) {
            return initReadIndex().get(score);
        }
        return null;
    }
}
