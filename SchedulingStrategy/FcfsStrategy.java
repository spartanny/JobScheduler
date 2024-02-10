package SchedulingStrategy;

import Entities.Job;
import Entities.Worker;

import java.util.List;
import java.util.PriorityQueue;

public class FcfsStrategy implements ISchedulingStrategy {

    public void run(PriorityQueue<Worker> pq, List<Job> jobs){
        // no need to sort the jobs assuming arrival time is 0 for all of them
        for(var job : jobs) {
            Worker current = pq.poll();
            assert current != null;
            current.addJob(job);
            current.setAvailableAt(current.getAvailableAt() + job.getDuration());
            pq.add(current);
        }

        for(var worker : pq)
            System.out.print(worker.toString());
    }
}
