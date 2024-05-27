package project.web.data.service.city;

import project.web.data.domain.City;
import project.web.data.dto.CityDTO;

import java.util.List;

public interface CityService {

    City getCityInHotel(Long hNum);
    public List<City> getCity(String name);

    boolean existsCity(String name);
}
