package SchedulingStrategy;

import Entities.Job;
import Entities.Worker;

import java.util.List;
import java.util.PriorityQueue;

public interface ISchedulingStrategy {

    void run(PriorityQueue<Worker> workers, List<Job> jobs);
}
