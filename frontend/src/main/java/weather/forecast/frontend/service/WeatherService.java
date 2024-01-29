package weather.forecast.frontend.service;


import weather.forecast.frontend.dto.PeriodForecastDto;
import weather.forecast.frontend.dto.PlaceDto;

import java.util.List;

public interface WeatherService {
    List<PeriodForecastDto> getAllForecast();

    PlaceDto findByNameAndTimestamp(String name);

}
