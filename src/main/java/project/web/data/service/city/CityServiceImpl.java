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
    public List<City> getCity(String name) {
        return cityRepository.findCityByName(name);
    }

    @Override
    public City getCityInHotel(Long hNum) {
        return cityRepository.findCityInHotel(hNum);
    }

    @Override
    public boolean existsCity(String name) {
        return cityRepository.existsBycName(name);
    }
}
