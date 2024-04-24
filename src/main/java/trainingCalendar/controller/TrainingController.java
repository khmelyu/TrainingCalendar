package trainingCalendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import trainingCalendar.entity.Training;
import trainingCalendar.rep.TrainingsRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    private final TrainingsRepository trainingRepository;

    @Autowired
    public TrainingController(TrainingsRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @GetMapping
    public List<Training> getAllTrainings(@RequestParam Integer month, @RequestParam Integer year, @RequestParam List<String> cities) {
        List<String> transformedCities = cities.stream()
                .map(city -> {
                    switch (city) {
                        case "msk":
                            return "Мск";
                        case "spb":
                            return "СПб";
                        case "online":
                            return "Онлайн";
                        default:
                            return city;
                    }
                })
                .collect(Collectors.toList());

        return trainingRepository.findActualTrainingsByMonthAndYearAndCities(month, year, transformedCities);
    }
}


