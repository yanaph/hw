package ua.fan.hw16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class MapUtilsTest {
    private ArrayList<String> target;

    @Test
    public void convertListToMapByWord_IfEmpty() {
        target = new ArrayList<>();
        Assertions.assertTrue(MapUtils.convertListToMapByWord(target).isEmpty());
    }

    @Test
    public void convertListToMapByWord_IfHasEmptyString() {
        target = new ArrayList<>(List.of(""));
        HashMap<String, Integer> wordsMap = new HashMap<>();
        wordsMap.put("", 0);
        Assertions.assertEquals(wordsMap, MapUtils.convertListToMapByWord(target));
    }

    @Test
    public void convertListToMapByWord_IfHasNull() {
        target = new ArrayList<>();
        target.add("hello");
        target.add(null);
        HashMap<String, Integer> wordsMap = new HashMap<>();
        wordsMap.put("hello", 5);
        Assertions.assertEquals(wordsMap, MapUtils.convertListToMapByWord(target));
    }

    @Test
    public void convertListToMapByWord() {
        target = new ArrayList<>(Arrays.asList("hello", "hola", "bonjour","1234"));
        HashMap<String, Integer> wordsMap = new HashMap<>();
        wordsMap.put("hello", 5);
        wordsMap.put("hola", 4);
        wordsMap.put("bonjour", 7);
        wordsMap.put("1234", 4);
        Assertions.assertEquals(wordsMap, MapUtils.convertListToMapByWord(target));
    }

    @Test
    public void convertListToMapByLengthIfEmpty() {
        target = new ArrayList<>();
        Assertions.assertTrue(MapUtils.convertListToMapByLength(target).isEmpty());
    }

    @Test
    public void convertListToMapByLength_IfHasEmptyString() {
        target = new ArrayList<>(List.of(""));
        HashMap<Integer, ArrayList<String>> wordsMap = new HashMap<>();
        wordsMap.put(0, new ArrayList<>(List.of("")));
        Assertions.assertEquals(wordsMap, MapUtils.convertListToMapByLength(target));
    }

    @Test
    public void convertListToMapByLength_IfHasNull() {
        target = new ArrayList<>();
        target.add("hola");
        target.add(null);
        HashMap<Integer, ArrayList<String>> wordsMap = new HashMap<>();
        wordsMap.put(4, new ArrayList<>(List.of("hola")));
        Assertions.assertEquals(wordsMap, MapUtils.convertListToMapByLength(target));
    }

    @Test
    public void convertListToMapByLength() {
        target = new ArrayList<>(Arrays.asList("hello", "hola", "bonjour","1234"));
        HashMap<Integer, ArrayList<String>> wordsMap = new HashMap<>();

        ArrayList<String> fourLetters = new ArrayList<>(Arrays.asList("hola", "1234"));
        ArrayList<String> fiveLetters = new ArrayList<>(List.of("hello"));
        ArrayList<String> sevenLetters = new ArrayList<>(List.of("bonjour"));

        wordsMap.put(4, fourLetters);
        wordsMap.put(5, fiveLetters);
        wordsMap.put(7, sevenLetters);

        Assertions.assertEquals(wordsMap, MapUtils.convertListToMapByLength(target));
    }
}