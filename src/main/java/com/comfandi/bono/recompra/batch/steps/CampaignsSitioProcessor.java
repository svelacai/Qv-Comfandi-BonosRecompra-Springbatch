package com.comfandi.bono.recompra.batch.steps;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.bonos.dto.CampaignsSitiosDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CampaignsSitioProcessor implements ItemProcessor<CampaignsSitiosDTO, CampaignsSitiosDTO> {
	
	@Override
    public CampaignsSitiosDTO process(CampaignsSitiosDTO campaignsSitiosDTO) throws Exception {
		
        // Aquí puedes agregar cualquier lógica de transformación si es necesario
        return campaignsSitiosDTO;
    }

}
