package trainingCalendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trainingCalendar.entity.Training;
import trainingCalendar.rep.TrainingsRepository;

import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    private final TrainingsRepository trainingRepository;

    @Autowired
    public TrainingController(TrainingsRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @GetMapping
    public List<Training> getAllTrainings(@RequestParam(required = false) Integer month, @RequestParam(required = false) Integer year) {
        if (month != null && year != null) {
            return trainingRepository.findActualTrainingsByMonthAndYear(month, year);
        } else {
            return trainingRepository.findActualTrainings();
        }
    }
}
