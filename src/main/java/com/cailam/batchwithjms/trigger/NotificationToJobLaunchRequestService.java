package com.cailam.batchwithjms.trigger;

import com.cailam.batchwithjms.model.Notification;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.messaging.Message;

import java.util.UUID;

public class NotificationToJobLaunchRequestService {

    private Job job;

    public void setJob(Job job) {
        this.job = job;
    }

    public JobLaunchRequest toRequest(Message<Notification> message) {

        Notification notification = message.getPayload();

        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder()
                .addString("run.id", UUID.randomUUID().toString())
                .addString("email", notification.getEmail())
                .addString("status", notification.getStatus());

        return new JobLaunchRequest(job, jobParametersBuilder.toJobParameters());
    }
}

