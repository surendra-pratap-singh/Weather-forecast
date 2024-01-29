package weather.forecast.frontend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import weather.forecast.frontend.entity.NightForecast;

@RepositoryRestResource
public interface NightForecastDao extends JpaRepository<NightForecast, Long> {

}
