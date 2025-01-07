package com.comfandi.bono.recompra.batch.client.steps;

import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.client.enties.Client;


public class ClientItemWriter implements ItemWriter<Client> {

	@Override
	public void write(Chunk<? extends Client> chunk) throws Exception {
		// TODO Auto-generated method stub
		
	}
 /*   @Override
    public void write(List<? extends Client> items) throws Exception {
        // Lógica para escribir los clientes, por ejemplo, persistir en la base de datos
        for (Client client : items) {
            // escribir en base de datos o archivo
        }
    }*/
}

