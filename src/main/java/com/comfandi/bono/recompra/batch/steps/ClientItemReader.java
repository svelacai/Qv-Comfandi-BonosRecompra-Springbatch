package com.comfandi.bono.recompra.batch.steps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.client.enties.Client;

import jakarta.persistence.EntityManagerFactory;

@Component
public class ClientItemReader {

    @Bean
    public JpaPagingItemReader<Client> clienteItemReader(@Autowired EntityManagerFactory entityManagerFactory) {
        JpaPagingItemReader<Client> reader = new JpaPagingItemReader<>();
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setQueryString("SELECT c FROM Client c WHERE c.state = :state AND c.clientCategory != :category");

        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("state", "Active");
        parameterValues.put("category", 'C');
        reader.setParameterValues(parameterValues);

        reader.setPageSize(10); // El tamaño de la página 
        
        // Imprimir los parámetros configurados en el reader
        System.out.println("Configurando JpaPagingItemReader---->>> ");
        return reader;
    }
}

