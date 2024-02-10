package Entities;

import Builder.JobBuilder;

public class Job {
    public String name;
    public int duration;
    public int priority;
    public int deadline;
    public User user;

    public Job(){}

    public String getName(){
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getPriority() {
        return priority;
    }

    public int getDeadline() {
        return deadline;
    }

    public User getUser() {
        return user;
    }
}
