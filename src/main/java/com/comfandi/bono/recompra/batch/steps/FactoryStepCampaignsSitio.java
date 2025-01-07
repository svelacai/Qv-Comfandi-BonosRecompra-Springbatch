package com.comfandi.bono.recompra.batch.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.comfandi.bono.recompra.batch.bono.steps.BonoDtoItemReader;
import com.comfandi.bono.recompra.batch.bono.steps.BonoDtoItemWriter;
import com.comfandi.bono.recompra.batch.bono.steps.BonoExecutionListener;
import com.comfandi.bono.recompra.batch.bonos.dto.CampaignsSitiosDTO;

@Component
public class FactoryStepCampaignsSitio {
   
    
    @Autowired
	private CampaignsSitioReader itemReader;
	
	@Autowired
	private CampaignsSitioWriter itemWriter;
    
    private static final Logger logger = LoggerFactory.getLogger(FactoryStepCampaignsSitio.class);

    
    public FactoryStepCampaignsSitio() {
        logger.info(">>>>  FactoryStepCampaignsSitio <<<<");
    }


    
    
    public Step factoryStep(String stepName, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        logger.info("Creando el Step: {}", stepName);

        Step step = new StepBuilder(stepName, jobRepository)
            .<CampaignsSitiosDTO, CampaignsSitiosDTO>chunk(1)
            .reader(itemReader)
            .writer(itemWriter)
            .transactionManager(transactionManager)
            .listener(new BonoExecutionListener())
            .faultTolerant()
            .skipLimit(3)
            .build();

        logger.info("Step {} creado correctamente", stepName);
        return step;
    }

}

