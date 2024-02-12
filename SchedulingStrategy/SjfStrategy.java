package SchedulingStrategy;

import Entities.Job;
import Entities.Worker;
import Threads.ThreadManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SjfStrategy implements ISchedulingStrategy {

    /**
     * Shortest Job first - SJF
     * Shortest job first (SJF), is a scheduling policy that selects the waiting process with the smallest execution time to execute next.
     * In case of tie choose the job according to the following order -
     * 1. Priority (higher priority job gets scheduled first)
     */

    @Override
    public void run(ThreadManager threadManager, List<Job> tasks) {
        List<Job> jobs = new ArrayList<>(tasks);
        jobs.sort(Comparator.comparingInt(Job::getDuration).thenComparing(Job::getPriority));
        for(var j : jobs){
            threadManager.assignJobToWorkerThread(j);
        }
    }
}
