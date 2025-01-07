package com.comfandi.bono.recompra.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


public class ApplicationRunner implements CommandLineRunner {

	 private static final Logger logger = LoggerFactory.getLogger(BatchBonorecompraApplication.class);

    @Autowired
    private JobLauncher jobLauncher;
    
    @Autowired
    private Job generateBonoJob;

	@Override
	public void run(String... args) throws Exception {

		logger.info(">>>>  ApplicationRunner <<<<");
		//jobLauncher.run(generateBonoJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis()).addString("uniqueParam", UUID.randomUUID().toString()).toJobParameters());
	}

}
