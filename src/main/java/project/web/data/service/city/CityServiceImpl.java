package project.web.data.service.city;

import org.springframework.stereotype.Service;
import project.web.data.domain.City;
import project.web.data.dto.CityDTO;
import project.web.data.repository.CityRepository;
import java.util.*;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public CityDTO getOneCity(String name) {
        City city = cityRepository.findBycName(name);

        CityDTO cityDTO = new CityDTO();
        cityDTO.setInfo(city.getCInfo());
        cityDTO.setName(city.getCName());
        cityDTO.setLat(city.getCLat());
        cityDTO.setLng(city.getCLong());

        return cityDTO;
    }

    @Override
    public List<City> getCityAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityInHotel(Long hNum) {
        return cityRepository.findCityInHotel(hNum);
    }
}
