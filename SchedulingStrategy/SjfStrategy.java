package SchedulingStrategy;

import Entities.Job;
import Entities.Worker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SjfStrategy implements ISchedulingStrategy {
    @Override
    public void run(PriorityQueue<Worker> workers, List<Job> tasks) {
        List<Job> jobs = new ArrayList<>(tasks);
        jobs.sort(Comparator.comparingInt(Job::getDuration));
        readJobs(workers, jobs);
    }
}
