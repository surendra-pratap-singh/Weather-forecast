package weather.forecast.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weather.forecast.frontend.dto.PeriodForecastDto;
import weather.forecast.frontend.dto.PlaceDto;
import weather.forecast.frontend.service.WeatherService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/forecasts")
    public List<PeriodForecastDto> getForecastData() {
        return weatherService.getAllForecast();
    }

    @GetMapping("/forecastsByPlace/{place}")
    public PlaceDto getData(@PathVariable String place) {
        return weatherService.findByNameAndTimestamp(place);
    }


}
