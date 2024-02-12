package Threads;

import Entities.Job;
import Entities.Worker;
import SchedulingStrategy.ISchedulingStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

// Holds instance of threads and abstracts it from client
// Responsibility :

/**
 * Manage Thread LifeCycle : Creation, Job Assignment and Storage of Thread Workers
 */
public class ThreadManager {
    private static ThreadManager INSTANCE = null;
    private PriorityQueue<Worker> pq;

    private ThreadManager() { // this should be private if you want to make it singleton.
        pq = new PriorityQueue<>(Comparator.comparingInt(Worker::getAvailableAt)
                .thenComparing(Worker::getId)
        );
        // so if 2 threads are getting available at same time, i should choose the one which has smaller id.
    }

    public static ThreadManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ThreadManager();
        }
        return INSTANCE;
    }

    public void assignJobToWorkerThread(Job j){
        // polling the worker with the earliest available time.
        if(pq.isEmpty()) throw new RuntimeException("No workers available");
        var worker = pq.poll();
        if(worker.getAvailableAt() <= j.getDeadline()){
            worker.setAvailableAt(worker.getAvailableAt() + j.duration);
            worker.addJob(j); // assigning the job
            pq.add(worker); // adding the worker to the pool
        }else {
            pq.add(worker);
        }
    }

    public void init(int numOfWorkers) {
        if(numOfWorkers <= 0)
            return;
        pq.clear();
        for(int i=0; i< numOfWorkers; i++) {
            Worker worker = new Worker(i+1);
            pq.add(worker);
            System.out.println("Worker spawned : " + (i+1));
        }
    }

    public void reset(){
        if(pq != null && !pq.isEmpty())
            this.init(pq.size());
    }

    public void print(){
        List<Worker> workers = new ArrayList<>();
        while(!pq.isEmpty()){
            workers.add(pq.poll());
        }
        workers.sort(Comparator.comparing(Worker::getId));
        for(var w : workers){
            System.out.println("Thread " + w.getId() + " : " + w.getJobs().toString());
        }
    }

}
