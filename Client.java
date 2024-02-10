import Builder.JobBuilder;
import Entities.Job;
import Entities.User;
import SchedulingStrategy.FcfsStrategy;
import Threads.ThreadManager;

import java.lang.*;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        System.out.println("Job scheduler client in action .... !");

        // Ensuring we have a singleton class
        ThreadManager threadManager = ThreadManager.getInstance();
        threadManager.init(2);

        // Create sample jobs
        JobBuilder jobBuilder = new JobBuilder();
        Job job1 = jobBuilder.name("J1").duration(10).priority(0).deadline(10).user(User.ROOT).build();
        Job job2 = jobBuilder.name("J2").duration(20).priority(0).deadline(40).user(User.ADMIN).build();
        Job job3 = jobBuilder.name("J3").duration(15).priority(2).deadline(40).user(User.ROOT).build();
        Job job4 = jobBuilder.name("J4").duration(30).priority(1).deadline(40).user(User.USER).build();
        Job job5 = jobBuilder.name("J5").duration(10).priority(2).deadline(30).user(User.USER).build();

        threadManager.schedule(new FcfsStrategy(), List.of(job1, job2, job3, job4, job5));
    }
}
