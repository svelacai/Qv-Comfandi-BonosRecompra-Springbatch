package com.comfandi.bono.recompra.batch.service.interfaces;

import java.util.List;

import com.comfandi.bono.recompra.batch.bonos.entities.Campaings;

public interface ICampaingsService {
	
	public abstract List<Campaings> getCampaignsByTypeAndState(Integer campaignType, boolean all);
	

}
