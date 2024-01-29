package weather.forecast.frontend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import weather.forecast.frontend.entity.Place;

import java.util.List;

@RepositoryRestResource
public interface PlaceDao extends JpaRepository<Place, Long> {

    List<Place> findByName(String placeName);

    @Query("SELECT e FROM Place e WHERE e.name = :name AND e.time = :time")
    Place findByNameAndTimestamp(@Param("name") String name, @Param("time") String time);
}
