package com.comfandi.bono.recompra.batch.bono.steps;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.bonos.dto.BonosDTO;

@Component
public class BonoDtoItemWriter implements ItemWriter<BonosDTO> {
	
	private static final Logger logger = LoggerFactory.getLogger(BonoDtoItemReader.class);


    @Override
    public void write(Chunk<? extends BonosDTO> chunk) throws Exception {
        logger.info("----------------------------------------------------------------------------------Escribiendo BonoDTO: ");

        for (BonosDTO item : chunk) {
            // Imprime los objetos en la consola o en el log
            logger.info("Escribiendo BonoDTO: " + chunk);
        }
    }
}
