package trainingCalendar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    private static final Logger logger = LoggerFactory.getLogger(TrainingController.class);
    private final TrainingsRepository trainingRepository;

    @Autowired
    public TrainingController(TrainingsRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @GetMapping
    public List<Trainings> getAllTrainings() throws JsonProcessingException {
        List<Trainings> trainings = trainingRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String trainingsJson = objectMapper.writeValueAsString(trainings);
        logger.info("Returning trainings: " + trainingsJson);

        return trainings;
    }
}
