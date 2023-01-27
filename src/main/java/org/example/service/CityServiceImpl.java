package org.example.service;

import org.example.dao.CityDao;
import org.example.dao.CityDaoImpl;
import org.example.model.CityEntity;

import java.util.List;

public class CityServiceImpl implements CityService {

    CityDao cityDao = new CityDaoImpl();


    @Override
    public List<CityEntity> selectSortedByCityName() {
        return cityDao.selectSortedByCityName();
    }

    @Override
    public List<CityEntity> selectSortedByCityCode() {
        return cityDao.selectSortedByCityCode();
    }
}
