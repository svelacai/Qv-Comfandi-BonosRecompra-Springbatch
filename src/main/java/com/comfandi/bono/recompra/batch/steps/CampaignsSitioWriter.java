package com.comfandi.bono.recompra.batch.steps;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.bonos.dto.CampaignsSitiosDTO;
import com.comfandi.bono.recompra.batch.client.repository.CampaignRepository;
import com.comfandi.bono.recompra.batch.client.repository.SiteRepository;

@Component
public class CampaignsSitioWriter implements ItemWriter<CampaignsSitiosDTO> {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private SiteRepository siteRepository;

    @Override
    public void write(Chunk<? extends CampaignsSitiosDTO> chunk) throws Exception {
        for (CampaignsSitiosDTO dto : chunk.getItems()) {
            // Guardar campañas
            campaignRepository.saveAll(dto.getCampaignEntities());
            // Guardar sitios
            siteRepository.saveAll(dto.getSiteEntities());
        }
    }
}
