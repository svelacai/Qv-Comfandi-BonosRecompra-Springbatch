package com.comfandi.bono.recompra.batch.service.interfaces;

import java.util.List;

import com.comfandi.bono.recompra.batch.client.enties.Client;


public interface IClientService  {
	
	abstract List<Client> getListClientsStateByCategory(String state, String category);

}
