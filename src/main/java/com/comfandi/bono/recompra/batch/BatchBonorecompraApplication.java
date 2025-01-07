package com.comfandi.bono.recompra.batch;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.comfandi.bono.recompra.batch.config.RestTemplateConfig;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@EnableBatchProcessing
@ComponentScan({"com.comfandi.bono.recompra.batch", "com.comfandi.bono.recompra.batch.bono.step" , "com.comfandi.bono.recompra.batch.steps"})
@Import(RestTemplateConfig.class)  // configuración de RestTemplate
public class BatchBonorecompraApplication {

	 private static final Logger logger = LoggerFactory.getLogger(BatchBonorecompraApplication.class);
	 
	   @Autowired
	    private JobLauncher jobLauncher;
	    
	    @Autowired
	    private static Job generateBonoJob;
	    
	    
	    public BatchBonorecompraApplication(JobLauncher jobLauncher) {
	        this.jobLauncher = jobLauncher;
	    }
	    
	    public void runJob() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
	    	jobLauncher.run(generateBonoJob, new JobParametersBuilder().addLong("time", System.currentTimeMillis()).addString("uniqueParam", UUID.randomUUID().toString()).toJobParameters()); // Ahora, esto está bien, porque estamos dentro de un contexto no estático
	    }	    

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		logger.info(">>>>  INICIA LA EJECUCION DE GENERACION DE BONOS <<<<");
		SpringApplication.run(BatchBonorecompraApplication.class, args);
		
		JobLauncher jobLauncher = new JobLauncher() {
			
			@Override
			public JobExecution run(Job job, JobParameters jobParameters) throws JobExecutionAlreadyRunningException,
					JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
				// TODO Auto-generated method stub
				return null;
			}
		}; 
		BatchBonorecompraApplication ba = new BatchBonorecompraApplication(jobLauncher);
		ba.runJob();

		logger.info(">>>>  FINALIZA LA EJECUCION DE GENERACION DE BONOS <<<<");
	}

}