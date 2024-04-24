package trainingCalendar.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import trainingCalendar.entity.Training;

import java.util.List;

@Repository
public interface TrainingsRepository extends JpaRepository<Training, Long> {
    @Query(value = "SELECT * FROM training t WHERE t.actual = true AND EXTRACT(MONTH FROM t.date) = :month AND EXTRACT(YEAR FROM t.date) = :year AND t.city IN (:cities)", nativeQuery = true)
    List<Training> findActualTrainingsByMonthAndYearAndCities(@Param("month") int month, @Param("year") int year, @Param("cities") List<String> cities);
}



