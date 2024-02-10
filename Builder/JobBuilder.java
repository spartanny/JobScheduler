package Builder;

import Entities.Job;
import Entities.User;

public class JobBuilder {
    private Job job = new Job();

    public JobBuilder name(String name){
        job.name = name;
        return this;
    }

    public JobBuilder duration(int duration){
        job.duration = duration;
        return this;
    }

    public JobBuilder priority(int priority){
        job.priority = priority;
        return this;
    }

    public JobBuilder deadline(int deadline){
        job.deadline = deadline;
        return this;
    }

    public JobBuilder user(User user){
        job.user = user;
        return this;
    }

    public Job build() {
        Job result = job;
        this.job = new Job();
        return result;
    }

}
