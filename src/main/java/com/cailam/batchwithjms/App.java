package com.cailam.batchwithjms;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableBatchProcessing
public class App 
{
    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);
    }
}
