package com.comfandi.bono.recompra.batch.config.jobs;

import javax.sql.DataSource;

import org.springframework.batch.core.JobKeyGenerator;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.repository.dao.DefaultExecutionContextSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.comfandi.bono.recompra.batch.config.ConversionConfig;

@Component
public class JobExplorerCampaignsSitio {

	@Autowired
	private ConversionConfig conversionConfig;

	@Autowired
	private JobKeyGenerator jobKeyGenerator;

	public JobExplorer createJobExplorer(DataSource dataSource, PlatformTransactionManager transactionManager)
			throws Exception {
		JobExplorerFactoryBean factoryBean = new JobExplorerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setJobKeyGenerator(jobKeyGenerator);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		factoryBean.setJdbcOperations(jdbcTemplate);
		factoryBean.setConversionService(conversionConfig.conversionService());
		factoryBean.setSerializer(new DefaultExecutionContextSerializer());
		factoryBean.setTransactionManager(transactionManager);
		return factoryBean.getObject();
	}
}
