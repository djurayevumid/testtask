package org.example.dao;

import org.example.model.CityEntity;
import org.example.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class CityDaoImpl implements CityDao {
    private final Session session = Util.getSessionFactory().openSession();

    public CityDaoImpl() {
    }

    @Override
    public List<CityEntity> selectSortedByCityName() {
        List<CityEntity> cities= null;
        try {
            cities = session.createQuery("from org.example.model.CityEntity order by city asc, city_code asc", CityEntity.class).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }

        return cities;
    }

    @Override
    public List<CityEntity> selectSortedByCityCode() {
        List<CityEntity> cities= null;
        try {
            cities = session.createQuery("from org.example.model.CityEntity c order by city_code asc , city asc", CityEntity.class).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }
        return cities;
    }
}
