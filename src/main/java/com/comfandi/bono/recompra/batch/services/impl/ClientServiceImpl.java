package com.comfandi.bono.recompra.batch.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.comfandi.bono.recompra.batch.client.enties.Client;
import com.comfandi.bono.recompra.batch.service.interfaces.IClientService;

@Service
public class ClientServiceImpl implements IClientService {
/*
	@Autowired
	private IClientsRepository clientRepository;
*/
	@Override
	public List<Client> getListClientsStateByCategory(String state, String category) {
		// TODO Auto-generated method stub
		return null;
	}


}
