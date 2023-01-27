package org.example.dao;

import org.example.model.CityEntity;

import java.util.List;

public interface CityDao {
    List<CityEntity> selectSortedByCityName();
    List<CityEntity> selectSortedByCityCode();
}
