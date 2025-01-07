package com.comfandi.bono.recompra.batch.client.datasources;

import java.util.HashMap;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.comfandi.bono.recompra.batch.client.repository",
		entityManagerFactoryRef = "entityManagerFactoryDb1", 
	    transactionManagerRef = "transactionManagerDb1")
public class DataSourceConfigClient {
	
/*	@Bean
    @ConfigurationProperties(prefix="spring.datasource.db1")
    public DataSourceProperties db1DataSourceProperties() {
        return new DataSourceProperties();
    }
	
    @Bean
    @Primary
    public DataSource db1DataSource() {
        return this.db1DataSourceProperties().initializeDataSourceBuilder().build();   
    }
    
  
	@Bean
	@Primary
	public EntityManagerFactoryBuilder entityManagerClient() {
		return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	}

	@Bean(name = "transactionManagerDb1")
	@Primary
	public PlatformTransactionManager transactionManagerDb1(
			@Qualifier("entityManagerFactoryDb1") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	

	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryDb1(EntityManagerFactoryBuilder builder,
			@Qualifier("db1DataSource") DataSource dataSourceDb1) {
		return builder
				.dataSource(dataSourceDb1)
				.packages("com.comfandi.bono.recompra.batch.client")
				.persistenceUnit("db1")
				.build();
	}
	*/

}
