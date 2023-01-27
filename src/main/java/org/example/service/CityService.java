package org.example.service;

import org.example.model.CityEntity;

import java.util.List;

public interface CityService {
    List<CityEntity> selectSortedByCityName();
    List<CityEntity> selectSortedByCityCode();
}
