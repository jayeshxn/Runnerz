package com.jayeshxn.runnerz.run;
/*Link to test endpoints in Postman:
    https://www.postman.com/lunar-module-astronaut-72491084/workspace/postman-api-fundamentals-student-expert/folder/27781329-68c73a75-90f5-4005-b3fd-7d6478668986?ctx=documentation*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }


    //GET Requests
    @GetMapping("/")
    public List<Run> getRuns() {
        return runRepository.findAll();
    }
    @GetMapping("/{id}")
    public Run getRun(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found");
        }

        return run.get();
    }

    //POST Requests
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void createRun(@RequestBody Run run) {
        runRepository.create(run);
    }

    //PUT Requests
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateRun(@PathVariable Integer id, @RequestBody Run run) {
        runRepository.update(id, run);
    }
    //DELETE Requests
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRun(@PathVariable Integer id) {
        runRepository.delete(id);
    }
}
