package org.example;

import org.example.model.CityEntity;
import org.example.service.CityService;
import org.example.service.CityServiceImpl;
import org.hibernate.Session;

import java.util.List;

public class Main {


    public static void main(String[] args) {


        CityService cityService = new CityServiceImpl();
//        List<String> strings = new ReaderClass().readFromFile();
//        Test t = new Test();
//


//        SortingClass sortingClass = new SortingClass();
//
//        System.out.println(sortingClass.sortDataByLetters(strings));
//
        cityService.selectSortedByCityName().stream().limit(5).forEach(System.out::println);
//
//        List<CityEntity> list = cityService.selectSortedByCityName();
//        for (CityEntity c : list) {
//            System.out.println(c);
//        }

    }
}