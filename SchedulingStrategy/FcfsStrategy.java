package SchedulingStrategy;

import Entities.Job;
import Entities.Worker;
import Threads.ThreadManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FcfsStrategy implements ISchedulingStrategy {

    @Override
    public void run(ThreadManager threadManager, List<Job> jobs){
        // no need to sort the jobs assuming arrival time is 0 for all of them
        for(var j : jobs){
            threadManager.assignJobToWorkerThread(j);
        }
    }
}
