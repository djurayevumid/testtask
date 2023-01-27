package org.example;

import org.example.Util;
import org.example.model.CityEntity;
import org.example.service.CityService;
import org.example.service.CityServiceImpl;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CityServiceImplTest {

    CityService service = new CityServiceImpl();
    private final Session session = Util.getSessionFactory().openSession();


    @Test
    void selectSortedByCityName() {

        assertArrayEquals(service.selectSortedByCityName().stream().limit(5).toArray(), session.createQuery("from org.example.model.CityEntity order by city asc, city_code asc", CityEntity.class)
                .stream().limit(5)
                .toArray());
    }

    @Test
    void selectSortedByCityCode() {

        assertArrayEquals(service.selectSortedByCityCode().stream().limit(5).toArray(), session.createQuery("from org.example.model.CityEntity order by city_code asc,  city asc", CityEntity.class)
                .stream().limit(5)
                .toArray());

    }
}