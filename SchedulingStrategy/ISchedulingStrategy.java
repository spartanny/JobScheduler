package SchedulingStrategy;

import Entities.Job;
import Entities.Worker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public interface ISchedulingStrategy {

    void run(PriorityQueue<Worker> workers, List<Job> jobs);
    default void readJobs(PriorityQueue<Worker> workers, List<Job> jobs) {
        for(var job : jobs) {
            Worker current = workers.poll();
            assert current != null;
            current.addJob(job);
            current.setAvailableAt(current.getAvailableAt() + job.getDuration());
            workers.add(current);
        }

        List<Worker> sortedWorkersList = new ArrayList<>(workers);
        sortedWorkersList.sort(Comparator.comparingInt(Worker::getId));

        for(var worker : sortedWorkersList)
            System.out.print(worker.toString());
    }
}
