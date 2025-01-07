package com.comfandi.bono.recompra.batch.config.jobs;

import javax.sql.DataSource;

import org.springframework.batch.core.DefaultJobKeyGenerator;
import org.springframework.batch.core.JobKeyGenerator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.DefaultExecutionContextSerializer;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.database.support.DefaultDataFieldMaxValueIncrementerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.comfandi.bono.recompra.batch.config.ConversionConfig;

@Component
public class JobRepositoryBonos {
	
	@Autowired
	private ConversionConfig conversionConfig;
	
	@Bean
	public JobKeyGenerator jobKeyGenerator() {
		return new DefaultJobKeyGenerator();
	}

	public JobRepository createJobRepository(DataSource dataSource, PlatformTransactionManager transactionManager)
			throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTransactionManager(transactionManager);
		factory.setIsolationLevelForCreate("ISOLATION_DEFAULT");
		factory.setTablePrefix("BATCH_");
		factory.setMaxVarCharLength(1000);
		factory.setDatabaseType("POSTGRES");
		factory.setJobKeyGenerator(jobKeyGenerator());
		factory.setConversionService(conversionConfig.conversionService());
		factory.setSerializer(new DefaultExecutionContextSerializer());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		factory.setJdbcOperations(jdbcTemplate);
		DefaultDataFieldMaxValueIncrementerFactory incrementerFactory = new DefaultDataFieldMaxValueIncrementerFactory(
				dataSource);
		factory.setIncrementerFactory(incrementerFactory);
		return factory.getObject();
	}

}
