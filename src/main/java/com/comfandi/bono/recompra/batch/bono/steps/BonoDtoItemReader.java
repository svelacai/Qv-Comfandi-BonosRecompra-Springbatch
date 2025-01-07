package com.comfandi.bono.recompra.batch.bono.steps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.bonos.dto.BonosDTO;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BonoDtoItemReader implements ItemReader<BonosDTO> {
	private static final Logger logger = LoggerFactory.getLogger(BonoDtoItemReader.class);
	
	@Autowired
	@Qualifier("db1DataSource")
	private DataSource dataSource; 

    
    public BonoDtoItemReader() throws Exception {
    	read();
    }
    
    @Override
    public BonosDTO read() throws Exception {
    	BonosDTO bonosDTO = new BonosDTO();
    	jdbcPagingItemReader();
    	return bonosDTO;
    }	



	public JdbcPagingItemReader<BonosDTO> jdbcPagingItemReader() throws Exception {
	    	logger.info("------------->>>>>  Ejecutando el metodo bonoItemReader()  <<<<<-------------------");	
		
	        JdbcPagingItemReader<BonosDTO> reader = new JdbcPagingItemReader<>();
			try {
			    reader.setDataSource(dataSource);
				reader.setQueryProvider(createQueryProvider());
			    reader.setRowMapper(new BeanPropertyRowMapper<>(BonosDTO.class));
			    reader.setPageSize(1000);
			}catch (Exception e) {
			    logger.info(" Exception ----------->>>>>" +e);	
			}
		    logger.info(" reader ----------->>>>>" +reader.getPage());

	        return reader;
	   }
	   
	    private PagingQueryProvider createQueryProvider() throws Exception {
	        SqlPagingQueryProviderFactoryBean factoryBean = new SqlPagingQueryProviderFactoryBean();
	        factoryBean.setDataSource(dataSource);
	        
			try {			
		        String selectClause = "SELECT sp.clientdocumenttype, sp.clientdocument, sp.plu, sp.productdescription, st.name, sp.clientcategory, cp.id as idCampaing ";
		        String fromClause =  "FROM salereport sp "
			            + "JOIN recompraproducts rc ON rc.plu = sp.plu "
			            + "JOIN campaigns cp ON rc.campaingId = cp.id "
                        + "JOIN sitios st ON st.name = sp.store";
			    String whereClause = "WHERE rc.campaingId = 'f9f48fc0-1d73-4f52-a46b-46922d5e6a85'::uuid "
			                        + "AND sp.clientdocument = 1083434 "
			                        + "AND cp.enddate::date <= TO_DATE('2024-12-31', 'YYYY-MM-DD')";
			    String sortKey = "sp.clientdocument";  
    
			    logger.info("------------->>>>>" +selectClause+ " "+ fromClause+ " "+whereClause);
			    String query = selectClause+ " "+ fromClause+ " "+whereClause;
			    
			    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			    List<Map<String, Object>> results = jdbcTemplate.queryForList(query);
			    for (Map<String, Object> row : results) {
			        System.out.println("Client Document: " + row.get("clientdocument"));
			        System.out.println("Product Description: " + row.get("productdescription"));
			        System.out.println("Store Name: " + row.get("name"));
			    }

			    factoryBean.setSelectClause(selectClause);
			    factoryBean.setFromClause(fromClause); 
			    factoryBean.setWhereClause(whereClause); 
			    factoryBean.setSortKey(sortKey); 

			} catch (Exception e) {
		    	logger.info(" Exception--------->>>>>  "+e);
			}

	        return factoryBean.getObject();
	    }
   
}	 



	
  /*  @Bean
	public JpaPagingItemReader<ReCompraProduct> bonoItemReader() {
	    logger.info("------------->>>>>  Ejecutando el metodo bonoItemReader()  <<<<<-------------------");
	    StepExecution stepExecution;
	    
	    JpaPagingItemReader<ReCompraProduct> reader = new JpaPagingItemReader<>();
	    reader.setEntityManagerFactory(entityManagerFactory);
	    reader.setPageSize(5); // Ajusta el tamaño de la página según tus necesidades
	    try {

	    
	     
	    String sqlQuery = "SELECT sp.clientdocumenttype, sp.clientdocument, sp.plu, sp.productdescription, st.name, sp.clientcategory, cp.id as idCampaing "
	            + "FROM salereport sp "
	            + "JOIN recompraproducts rc ON rc.plu = sp.plu "
	            + "JOIN campaigns cp ON rc.campaingId = cp.id "
	            + "JOIN sitios st ON st.name = sp.store "
	            + "WHERE rc.campaingId  = :campaignId "
	            + "AND sp.clientdocument = :clientdocument "
	            + "AND cp.enddate::date <= :endDate";
	   /* String sqlQuery = "SELECT * FROM recompraproducts "
                + "WHERE id = :id";	    
	  /*  reader.setParameterValues(Map.of(
	            "id", UUID.fromString("99776a2a-e500-41c5-8c9e-16a35cc651c1") 
	    ));	 */                
	  /*  reader.setQueryString(sqlQuery);


	    reader.setParameterValues(Map.of(
	            "campaignId", "f9f48fc0-1d73-4f52-a46b-46922d5e6a85",
	            "clientdocument", "1083434",
	            "endDate", new Date() // Fecha actual
	    ));
	   
	        // Inicia la paginación
	        reader.afterPropertiesSet();  
		    logger.info("------------->>>>>  Ejecutando el metodo bonoItemReader()  <<<<<-------------------"+sqlQuery);
		    logger.info("------------->>>>>  Ejecutando el metodo bonoItemReader()  <<<<<-------------------"+reader.getPage());
	    } catch (Exception e) {
	        logger.error("Error al configurar el JpaPagingItemReader: ", e);
	    }  

	    return reader;
	}
}*/

