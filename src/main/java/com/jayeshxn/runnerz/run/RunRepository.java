package com.jayeshxn.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    public List<Run> findAll() {
        return runs;
    }

    public Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Integer id, Run run) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete (Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()){
            runs.remove(existingRun.get());
        }
    }
    @PostConstruct
    private void init() {
        runs.add(new Run(
            1,
            "First Run",
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(1),
            5,
            Location.OUTDOOR
        ));

        runs.add(
                new Run(
                        2,
                        "Second Run",
                        LocalDateTime.now().plusHours(2),
                        LocalDateTime.now().plusHours(3),
                        10,
                        Location.INDOOR
                )
        );
    }
}
