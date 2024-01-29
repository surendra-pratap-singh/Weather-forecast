package weather.forecast.frontend.mapper;

import org.springframework.stereotype.Component;
import weather.forecast.frontend.dto.PeriodForecastDto;
import weather.forecast.frontend.dto.PlaceDto;
import weather.forecast.frontend.entity.DayForecast;
import weather.forecast.frontend.entity.NightForecast;
import weather.forecast.frontend.entity.Place;
import weather.forecast.frontend.utils.Utils;

@Component
public class EntityToDtoMapper {

    Utils utils = new Utils();

    public PeriodForecastDto dayToPeriodForecastMapper(DayForecast dayForecast) {
        PeriodForecastDto periodForecastDto = new PeriodForecastDto();
        periodForecastDto.setPhenomenon(dayForecast.getPhenomenon());
        periodForecastDto.setText(dayForecast.getText());
        periodForecastDto.setTempmax(dayForecast.getTempmax());
        periodForecastDto.setTempmin(dayForecast.getTempmin());
        periodForecastDto.setForecastId(dayForecast.getForecastId());
        periodForecastDto.setForecastDate(dayForecast.getForecastDate());
        periodForecastDto.setDayOfWeek(utils.getDayFromDate(dayForecast.getForecastDate()));
        periodForecastDto.setFormattedDate(utils.formatDate(dayForecast.getForecastDate()));
        return periodForecastDto;
    }

    public PeriodForecastDto nightToPeriodForecastMapper(NightForecast nightForecast) {
        PeriodForecastDto periodForecastDto = new PeriodForecastDto();
        periodForecastDto.setPhenomenon(nightForecast.getPhenomenon());
        periodForecastDto.setText(nightForecast.getText());
        periodForecastDto.setTempmax(nightForecast.getTempmax());
        periodForecastDto.setTempmin(nightForecast.getTempmin());
        periodForecastDto.setForecastId(nightForecast.getForecastId());
        periodForecastDto.setForecastDate(nightForecast.getForecastDate());
        periodForecastDto.setDayOfWeek(utils.getDayFromDate(nightForecast.getForecastDate()));
        periodForecastDto.setFormattedDate(utils.formatDate(nightForecast.getForecastDate()));
        return periodForecastDto;
    }

    public PlaceDto placeMapper(Place place) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setName(place.getName());
        placeDto.setPhenomenon(place.getPhenomenon());
        placeDto.setTemp(place.getTemp());
        placeDto.setTime(place.getTime());
        return placeDto;
    }


}
