package org.spring.springboot.service;

import org.spring.springboot.domain.City;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityService {

    /**
     * 获取城市
     *
     */
    City getCityByName(String cityName);

    /**
     * 新增城市信息
     *
     */
    void saveCity(String cityName);

    /**
     * 更新城市信息
     *
     */
    void updateCityDescription(String cityName, String description);

}
