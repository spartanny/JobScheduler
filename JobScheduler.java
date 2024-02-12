import Entities.Job;
import SchedulingStrategy.ISchedulingStrategy;
import Threads.ThreadManager;

import java.util.List;

public class JobScheduler {
    private final ISchedulingStrategy strategy;
    private final ThreadManager threadManager;
    JobScheduler(ISchedulingStrategy strategy, ThreadManager threadManager){
        this.strategy = strategy;
        this.threadManager = threadManager;
    }
    public void scheduleJobs(List<Job> jobs){
        strategy.run(threadManager,jobs);
        threadManager.print();
    }
}
