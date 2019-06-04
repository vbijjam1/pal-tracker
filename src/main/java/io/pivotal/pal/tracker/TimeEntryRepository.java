package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry);

    public TimeEntry  find(long timeId);

    public List<TimeEntry> list();

    public TimeEntry update(long id, TimeEntry timeEntry);

    public void delete(long id);

}
