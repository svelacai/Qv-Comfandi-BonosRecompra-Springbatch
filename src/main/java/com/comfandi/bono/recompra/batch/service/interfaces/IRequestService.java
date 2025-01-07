package com.comfandi.bono.recompra.batch.service.interfaces;

import java.util.List;

import com.comfandi.bono.recompra.batch.bonos.entities.Request;

public interface IRequestService {
	
	abstract void saveAll(List<Request> listRequest);

}
