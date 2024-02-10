package Threads;

import Entities.Job;
import Entities.Worker;
import SchedulingStrategy.ISchedulingStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

// Holds instance of threads and abstracts it from client
public class ThreadManager {
    private static ThreadManager INSTANCE = null;
    PriorityQueue<Worker> pq;

    public ThreadManager() {
        pq = new PriorityQueue<Worker>(Comparator.comparingInt(Worker::getAvailableAt));
    }

    public static ThreadManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ThreadManager();
        }
        return INSTANCE;
    }

    public void init(int numOfWorkers) {
        if(numOfWorkers <= 0)
            return;
        for(int i=0; i< numOfWorkers; i++) {
            Worker worker = new Worker(i+1);
            pq.add(worker);
            System.out.println("Worker spawned : " + (i+1));
        }
    }

    public void schedule(ISchedulingStrategy strategy, List<Job> jobs) {
        strategy.run(pq, jobs);
    }
}
