package com.comfandi.bono.recompra.batch.bono.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.comfandi.bono.recompra.batch.bonos.dto.BonosDTO;




@Component
public class FactoryStepBonos {
	@Autowired
	private BonoDtoItemReader bonoDtoItemReader;
	
	@Autowired
	private BonoDtoItemWriter bonoDtoItemWriter;

	
	private static final Logger logger = LoggerFactory.getLogger(FactoryStepBonos.class);
	
//	public Step factoryStep(JobRepository jobRepository) {
//		return new StepBuilder("generateBonoStep", jobRepository)
//				.<BonosDTO, BonosDTO>chunk(1000)
//				.reader(bonoDtoItemReader)
//				//.processor(itemProcessor)
//				.writer(bonoDtoItemWriter)
//				.transactionManager(transactionManager)
//				//.listener(new BonoExecutionListener())
//				.faultTolerant()
//				.skipLimit(3)
//				.build();
		
		
		public Step factoryStep(String stepName, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
			return new StepBuilder(stepName, jobRepository)
					.<BonosDTO, BonosDTO>chunk(1000)
					.reader(bonoDtoItemReader)
					//.processor(itemProcessor)
					.writer(bonoDtoItemWriter)
					.transactionManager(transactionManager)
					.listener(new BonoExecutionListener())
					.faultTolerant()
					.skipLimit(3)
					.build();
	}		
	}

