package trainingCalendar.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trainingCalendar.entity.Training;

import java.util.List;

@Repository
public interface TrainingsRepository extends JpaRepository<Training, Long> {
    @Query("SELECT t FROM Training t WHERE t.actual = true")
    List<Training> findActualTrainings();
}