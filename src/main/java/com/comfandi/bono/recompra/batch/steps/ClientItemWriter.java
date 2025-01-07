package com.comfandi.bono.recompra.batch.steps;

import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.client.enties.Client;

@Component
public class ClientItemWriter implements ItemWriter<Client> {

    // Sobrescribimos el método write de ItemWriter para recibir List<Client>
  /*  @Override
    public void write(List<? extends Client> clients) throws Exception {
        System.out.println("Escribiendo clientes en ClientItemWriter ------------------------------- ");
        for (Client client : clients) {
            // En este punto, puedes acceder a cada client
            System.out.println("Client: " + client.toString());
        }
    }*/

	@Override
	public void write(Chunk<? extends Client> chunk) throws Exception {
        System.out.println("Escribiendo clientes en ClientItemWriter ------------------------------- ");

	}
}



