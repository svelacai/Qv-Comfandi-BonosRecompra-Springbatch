package com.comfandi.bono.recompra.batch.bonos.datasources;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
		basePackages = {"com.comfandi.bono.recompra.batch.bonos.repository"},
		entityManagerFactoryRef = "entityManagerFactoryDb1", 
	    transactionManagerRef = "transactionManagerDb1")
public class DataSourceConfigBonos {

	//Obtiene las propiedades del properties.yml
	@Bean
    @ConfigurationProperties(prefix="spring.datasource.db1")
    public DataSourceProperties db1DataSourceProperties() {
        return new DataSourceProperties();
    }
	
	//Obtiene las propiedades de configuracion de la base de datos db1
    @Bean
    @Primary
    @Qualifier("db1DataSource")
    public DataSource db1DataSource() {
        return this.db1DataSourceProperties().initializeDataSourceBuilder().build();   
    }
    
  
    //Gestion de configuracion para JPA
	@Bean
	@Qualifier("entityManagerBonos")
	public EntityManagerFactoryBuilder entityManagerBonos() {
		return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	}

	//Administra las tranasacciones de la base de datos db1
	@Bean(name = "transactionManagerDb1")
	public PlatformTransactionManager transactionManagerDb1(
	        @Qualifier("entityManagerFactoryDb1") EntityManagerFactory entityManagerFactory) {
	    return new JpaTransactionManager(entityManagerFactory);
	}

	

	//Gestion del ciclo de vida de las entidades JPA para la base de datos db1
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryDb1(@Qualifier("entityManagerBonos") EntityManagerFactoryBuilder builder,
			@Qualifier("db1DataSource") DataSource dataSourceDb1) {
		return builder
				.dataSource(dataSourceDb1)
				.packages("com.comfandi.bono.recompra.batch.bonos")
				.persistenceUnit("db1")
				.build();
	}

}
