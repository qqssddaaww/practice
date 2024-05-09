package project.web.data.service.city;

import project.web.data.domain.City;
import project.web.data.dto.CityDTO;

import java.util.List;

public interface CityService {
    public CityDTO getOneCity(String name);
    public List<City> getCityAll();

    City getCityInHotel(Long hNum);
}
