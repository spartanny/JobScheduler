package SchedulingStrategy;

import Entities.Job;
import Entities.Worker;

import java.util.List;
import java.util.PriorityQueue;

public class FcfsStrategy implements ISchedulingStrategy {

    @Override
    public void run(PriorityQueue<Worker> workers, List<Job> jobs){
        // no need to sort the jobs assuming arrival time is 0 for all of them
        readJobs(workers, jobs);
    }
}
