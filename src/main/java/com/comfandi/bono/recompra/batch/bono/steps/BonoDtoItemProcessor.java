package com.comfandi.bono.recompra.batch.bono.steps;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.bonos.dto.BonosDTO;
import com.comfandi.bono.recompra.batch.bonos.entities.ReCompraProduct;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class BonoDtoItemProcessor implements ItemProcessor<BonosDTO, BonosDTO> {
	
	private static final Logger logger = LoggerFactory.getLogger(BonoDtoItemReader.class);
	
	public BonoDtoItemProcessor() {
		super();
		//preuba();
		
	}

	@Override
	public BonosDTO process(BonosDTO item) throws Exception {
    	logger.info("--------------------------------------- process(BonosDTO item)"+item);

		return item;
	}
	
	public void preuba() {
    	logger.info("--------------------------------------- pruebaaaa()");

	}
}
