package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository =timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate){

        TimeEntry timeEntry = this.timeEntryRepository.create(timeEntryToCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(timeEntry);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id){


        TimeEntry timeEntry =this.timeEntryRepository.find(id);

        if(timeEntry==null){
            return ResponseEntity.status( HttpStatus.NOT_FOUND).build();
        }




       return ResponseEntity.ok().body(timeEntry);
    }



    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list(){

        return ResponseEntity.ok().body(this.timeEntryRepository.list());
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(@PathVariable long id,@RequestBody TimeEntry timeEntryToUpdate){

        TimeEntry timeEntry =this.timeEntryRepository.update(id,timeEntryToUpdate);

        if(timeEntry==null){
            return ResponseEntity.status( HttpStatus.NOT_FOUND).build();
        }


        return ResponseEntity.ok().body(timeEntry);
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(@PathVariable long id){

        this.timeEntryRepository.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
