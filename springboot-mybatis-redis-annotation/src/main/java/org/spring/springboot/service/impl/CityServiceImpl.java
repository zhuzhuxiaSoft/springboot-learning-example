package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {


    // 模拟数据库存储
    private Map<String, City> cityMap = new HashMap<String, City>();

    @CachePut(value = "baseCityInfo", key="#cityName")
    public void saveCity(String cityName){
        // 模拟数据库插入操作
        cityMap.put(cityName, getCity(cityName));
    }

    @Cacheable(value = "baseCityInfo", key="#cityName")
//    @CachePut(value = "baseCityInfo", key="#cityName")
    public City getCityByName(String cityName){
        // 模拟数据库查询并返回
    	System.out.println("执行查询");
    	City city = cityMap.get(cityName);
        return city;
    }

    @CachePut(value = "baseCityInfo", key="#cityName")
    public void updateCityDescription(String cityName, String description){
        City city = cityMap.get(cityName);
        city.setDescription(description);
        // 模拟更新数据库
        cityMap.put(cityName, city);
    }
    
    private City getCity(String name){
    	if(name.equals("上海")){
    		
    		return new City(1L, 10L, "上海", "人称魔都的地方");
    	}else{
    		
    		return new City(2L, 20L, "北京", "中国帝都");
    	}
    }

}
