package weather.forecast.frontend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import weather.forecast.frontend.entity.DayForecast;

@RepositoryRestResource
public interface DayForecastDao extends JpaRepository<DayForecast, Long> {

}
