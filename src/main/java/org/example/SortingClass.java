package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingClass {

    public Map<Integer, String> sortDataByLetters(List<String> data) throws ArrayIndexOutOfBoundsException {

        Map<Integer, String> result = new HashMap<>();

        for (String datum : data) {
            result.put(Integer.parseInt(datum.split(",")[0]), datum.split(",")[1]);
        }

        return result.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));

    }

    public Map<Integer, String> sortDataByNumbers(List<String> data) throws ArrayIndexOutOfBoundsException {

        Map<Integer, String> result = new HashMap<>();

        for (String datum : data) {
            result.put(Integer.parseInt(datum.split(",")[0]), datum.split(",")[1]);
        }
        return result.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (e1, e2) -> e1, LinkedHashMap::new));

    }
}


