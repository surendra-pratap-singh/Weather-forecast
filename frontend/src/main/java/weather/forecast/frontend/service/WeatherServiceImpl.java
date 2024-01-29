package weather.forecast.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.forecast.frontend.dao.DayForecastDao;
import weather.forecast.frontend.dao.ForecastDao;
import weather.forecast.frontend.dao.NightForecastDao;
import weather.forecast.frontend.dao.PlaceDao;
import weather.forecast.frontend.dto.PeriodForecastDto;
import weather.forecast.frontend.dto.PlaceDto;
import weather.forecast.frontend.mapper.EntityToDtoMapper;
import weather.forecast.frontend.utils.Utils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    ForecastDao forecastDao;
    @Autowired
    DayForecastDao dayForecastDao;
    @Autowired
    NightForecastDao nightForecastDao;
    @Autowired
    PlaceDao placeDao;
    @Autowired
    EntityToDtoMapper entityToDtoMapper;
    Utils utils = new Utils();

    @Override
    public List<PeriodForecastDto> getAllForecast() {
        List<PeriodForecastDto> periodForecastDtoList = new ArrayList<PeriodForecastDto>();
        if (utils.isDayOrNight(LocalTime.now()).equalsIgnoreCase("day"))
            dayForecastDao.findAll().forEach(forecast -> {
                periodForecastDtoList.add(entityToDtoMapper.dayToPeriodForecastMapper(forecast));
            });
        else
            nightForecastDao.findAll().forEach(forecast -> {
                periodForecastDtoList.add(entityToDtoMapper.nightToPeriodForecastMapper(forecast));
            });

        return periodForecastDtoList;
    }

    @Override
    public PlaceDto findByNameAndTimestamp(String name) {
        PlaceDto placeDto = new PlaceDto();
        if (utils.isDayOrNight(LocalTime.now()).equalsIgnoreCase("day"))
            return entityToDtoMapper.placeMapper(placeDao.findByNameAndTimestamp(name, "Day"));
        else
            return entityToDtoMapper.placeMapper(placeDao.findByNameAndTimestamp(name, "Night"));

    }


}
