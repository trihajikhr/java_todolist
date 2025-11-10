package todolist;

import java.util.ArrayList;
import java.time.LocalDate;

public class Project {
    public String label;
    public String description;
    public int prior;
    public LocalDate startTime;
    public LocalDate endTime;
    ArrayList<Inbox> inbox = new ArrayList<>();

    Project(String label, String description, int prior, LocalDate startTime, LocalDate endTime){
        this.label = label;
        this.description = description;
        this.prior = prior;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    Project() {}
}
