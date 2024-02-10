package Entities;

import java.util.ArrayList;
import java.util.List;

// Workers are threads that will execute the jobs in this system
public class Worker {
    //jobs that will be assigned to this thread
    List<String> jobs;
    int availableAt;
    int id;

    public int getAvailableAt() {
        return availableAt;
    }
    public void setAvailableAt(int availableAt) {
        this.availableAt = availableAt;
    }

    public Worker(int id) {
        jobs = new ArrayList<>();
        availableAt = 0;
        this.id = id;
    }

    public void addJob(Job j) {
        jobs.add(j.getName());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(jobs == null || jobs.size() == 0)
            return "";

        builder.append("T").append(Integer.valueOf(id).toString()).append(": ");
        for(var job : jobs) {
            builder.append(job).append(", ");
        }
        builder.setLength(builder.length()-2);
        builder.append('\n');
        return builder.toString();
    }
}
