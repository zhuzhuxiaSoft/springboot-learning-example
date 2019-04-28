package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;


    @RequestMapping(value = "/find/{cityName}/{flag}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("cityName") String cityName, @PathVariable("flag") String flag) {
        return cityService.getCityByName(cityName);
    }

    @RequestMapping(value = "/create/{cityName}", method = RequestMethod.GET)
    public String createCity(@PathVariable("cityName") String cityName) {
        cityService.saveCity(cityName);
        return "success";
    }

    @RequestMapping(value = "/update/{cityName}", method = RequestMethod.GET)
    public String modifyCity(@PathVariable("cityName") String cityName) {
        cityService.updateCityDescription(cityName, "哈哈，改描述");
        return "success";
    }

    
}
