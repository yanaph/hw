package ua.fan.hw16;

import java.util.*;

public class MapUtils {
    public static HashMap<String, Integer> convertListToMapByWord(ArrayList<String> strings) {
        HashMap<String, Integer> words = new HashMap<>();
        for (String string : strings) {
            if (string != null) {
                if (string.isEmpty() && !words.containsKey("")) {
                    words.put("", 0);
                } else {
                    words.put(string, string.length());
                }
            }
        }
        return words;
    }

    public static HashMap<Integer, ArrayList<String>> convertListToMapByLength(ArrayList<String> strings) {
        HashMap<Integer, ArrayList<String>> wordsByLength = new HashMap<>();
        for (String str : strings) {
            if (str != null) {
                if (str.isEmpty()){
                    wordsByLength.put(0, new ArrayList<>(List.of("")));
                } else {
                    ArrayList<String> words = new ArrayList<>();
                    int length = str.length();
                    words.add(str);
                    if (!wordsByLength.containsKey(length)) {
                        wordsByLength.put(length, words);
                    } else {
                        wordsByLength.get(length).add(str);
                    }
                }
            }
        }
        return wordsByLength;
    }
}
