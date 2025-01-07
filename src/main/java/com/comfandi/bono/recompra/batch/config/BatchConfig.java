package com.comfandi.bono.recompra.batch.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.comfandi.bono.recompra.batch.bono.steps.FactoryStepBonos;
import com.comfandi.bono.recompra.batch.bonos.dto.BonosDTO;
import com.comfandi.bono.recompra.batch.bonos.dto.CampaignsSitiosDTO;
import com.comfandi.bono.recompra.batch.config.jobs.JobExplorerBonos;
import com.comfandi.bono.recompra.batch.config.jobs.JobExplorerCampaignsSitio;
import com.comfandi.bono.recompra.batch.config.jobs.JobRepositoryBonos;
import com.comfandi.bono.recompra.batch.config.jobs.JobRepositoryCampaignsSitio;
import com.comfandi.bono.recompra.batch.steps.FactoryStepCampaignsSitio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "spring.batch.db1")
public class BatchConfig {

    private static final Logger logger = LoggerFactory.getLogger(BatchConfig.class);

    public BatchConfig() {
        logger.info(">>>>  BatchConfig <<<<");
    }

    @Autowired
    private ItemReader<BonosDTO> itemReaderBono;
    
    @Autowired
    private ItemProcessor<BonosDTO, BonosDTO> itemProcessorBono;
    
    @Autowired
    private FactoryStepBonos factoryStepBonos;
    
    @Autowired
    private JobRepositoryBonos jobRepositoryBono;
    
    @Autowired
    private JobExplorerBonos jobExplorerBono;    

    @Autowired
    private ItemReader<CampaignsSitiosDTO> itemReaderCampaignsSitio;

    @Autowired
    private ItemProcessor<CampaignsSitiosDTO, CampaignsSitiosDTO> itemProcessorCampaignsSitio;

    @Autowired
    private FactoryStepCampaignsSitio factoryStepCampaignsSitio;

    @Autowired
    private JobRepositoryCampaignsSitio jobRepositoryCampaignsSitio;

    @Autowired
    private JobExplorerCampaignsSitio jobExplorerCampaignsSitio;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    
    @Bean
    @Primary
    public JobRepository jobRepository(@Qualifier("db1DataSource") DataSource dataSource,
                                       PlatformTransactionManager transactionManager) throws Exception {
        return jobRepositoryBono.createJobRepository(dataSource, transactionManager);
    }

    @Bean
    public JobExplorer jobExplorer(@Qualifier("db1DataSource") DataSource dataSource,
                                   PlatformTransactionManager transactionManager) throws Exception {
        return jobExplorerBono.createJobExplorer(dataSource, transactionManager);
    }
    

    @Bean
    @Profile("bonos")
    public Job generateBonoJob(JobRepository jobRepository, Step generateBonoStep) {
        return new JobBuilder("generateBonoJob", jobRepository)
                   .incrementer(new RunIdIncrementer())
                   .start(generateBonoStep)
                   .build();
    }

    @Bean
    @Profile("bonos")
    public Step generateBonoStep(JobRepository jobRepository) {
        return factoryStepBonos.factoryStep("generateBonoStep", jobRepository, transactionManager);
    }
    
   

    @Bean
    @Profile("campaignsSitio")
    public Job generateCampaignsSitioJob(JobRepository jobRepository, Step generateCampaignsSitioStep) {
        return new JobBuilder("generateCampaignsSitioJob", jobRepository)
                   .incrementer(new RunIdIncrementer())
                   .start(generateCampaignsSitioStep)
                   .build();
    }

    @Bean
    @Profile("campaignsSitio")
    public Step generateCampaignsSitioStep(JobRepository jobRepository) {
        return factoryStepCampaignsSitio.factoryStep("generateCampaignsSitioStep", jobRepository, transactionManager);
    }
}
