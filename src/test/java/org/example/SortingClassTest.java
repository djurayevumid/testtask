package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SortingClassTest {

    @Test
    void sortDataByLettersTest() {
        SortingClass sortingClass = new SortingClass();
        List<String> data = new ArrayList<>();
        data.add("123,Delver");
        data.add("122,Moscow");
        data.add("121,NewYork");
        data.add("120,SomethingElse");
        data.add("119,IDontKnow");
        LinkedHashMap<Integer, String> expectingResult = new LinkedHashMap<>();
        expectingResult.put(123, "Delver");
        expectingResult.put(119, "IDontKnow");
        expectingResult.put(122, "Moscow");
        expectingResult.put(121, "NewYork");
        expectingResult.put(120, "SomethingElse");
        Map<Integer, String> actualResult = sortingClass.sortDataByLetters(data);

        Assertions.assertEquals(expectingResult, actualResult);

    }

    @Test
    void sortDataByLettersTestWhenThereIsNoCities() {
        SortingClass sortingClass = new SortingClass();
        List<String> data = new ArrayList<>();
        data.add("123");
        data.add("122");
        data.add("121");
        data.add("120");
        data.add("119");
        Throwable thrown = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            sortingClass.sortDataByLetters(data);
        });
        assertNotNull(thrown.getMessage());
    }

    @Test
    void sortDataByLettersTestWhenThereIsNoIndexes() {
        SortingClass sortingClass = new SortingClass();
        List<String> data = new ArrayList<>();
        data.add("Delver");
        data.add("IDontKnow");
        data.add("Moscow");
        data.add("NewYork");
        data.add("SomethingElse");
        Throwable thrown = assertThrows(NumberFormatException.class, () -> {
            sortingClass.sortDataByLetters(data);
        });
        assertNotNull(thrown.getMessage());
    }


    //Testing of the sorting by numbers


    @Test
    void sortDataByNumbers() {
        SortingClass sortingClass = new SortingClass();
        List<String> data = new ArrayList<>();
        data.add("123,Delver");
        data.add("122,Moscow");
        data.add("121,NewYork");
        data.add("120,SomethingElse");
        data.add("119,IDontKnow");
        LinkedHashMap<Integer, String> expectingResult = new LinkedHashMap<>();
        expectingResult.put(119, "IDontKnow");
        expectingResult.put(120, "SomethingElse");
        expectingResult.put(121, "NewYork");
        expectingResult.put(122, "Moscow");
        expectingResult.put(123, "Delver");
        Map<Integer, String> actualResult = sortingClass.sortDataByNumbers(data);

        Assertions.assertEquals(expectingResult, actualResult);
    }

    @Test
    void sortDataByNumbersWhenThereAreNoIndexes() {
        SortingClass sortingClass = new SortingClass();
        List<String> data = new ArrayList<>();
        data.add("Delver");
        data.add("IDontKnow");
        data.add("Moscow");
        data.add("NewYork");
        data.add("SomethingElse");
        Throwable thrown = assertThrows(NumberFormatException.class, () -> {
            sortingClass.sortDataByNumbers(data);
        });
        assertNotNull(thrown.getMessage());
    }


    @Test
    void sortDataByNumbersWhenThereAreNoCities() {
        SortingClass sortingClass = new SortingClass();
        List<String> data = new ArrayList<>();
        data.add("123");
        data.add("122");
        data.add("121");
        data.add("120");
        data.add("119");
        Throwable thrown = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            sortingClass.sortDataByNumbers(data);
        });
        assertNotNull(thrown.getMessage());
    }
}