package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long,TimeEntry> timeEntries = new HashMap<Long,TimeEntry>();
    private long id=0l;


    public TimeEntry create(TimeEntry timeEntry){
        id = id + 1;
        timeEntry.setId(id);
        timeEntries.put(timeEntry.getId(),timeEntry);

        return timeEntries.get(timeEntry.getId());

    }

    public TimeEntry find(long timeId){

        return timeEntries.get(timeId);

    }

    public List<TimeEntry> list(){

        return timeEntries.values().stream().collect(Collectors.toList());
    }

    public TimeEntry update(long id, TimeEntry timeEntry){

        TimeEntry updatedValue = null;

        if(timeEntries.containsKey(id)){
            timeEntry.setId(id);
            timeEntries.put(id,timeEntry);
            updatedValue = timeEntries.get(id);
        }

        return updatedValue;
    }

    public void delete(long id){

        if(timeEntries.containsKey(id)){
            timeEntries.remove(id);

        }



    }
}
