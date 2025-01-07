package com.comfandi.bono.recompra.batch.steps;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.client.enties.Client;


@Component
public class ClientItemProcessor implements ItemProcessor<Client, List<Client>> {

	@Override
	public List<Client> process(Client clientes) throws Exception {
		List<Client> cli = new ArrayList<>();
		System.out.println("clientes ---> "+clientes);
		
		return cli;
	}
	

}
