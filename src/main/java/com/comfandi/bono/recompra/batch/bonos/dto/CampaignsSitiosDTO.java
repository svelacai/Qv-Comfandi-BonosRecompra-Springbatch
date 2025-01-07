package com.comfandi.bono.recompra.batch.bonos.dto;

import java.io.Serializable;
import java.util.List;

import com.comfandi.bono.recompra.batch.bonos.entities.Campaings;
import com.comfandi.bono.recompra.batch.bonos.entities.Sitios;

import lombok.Data;

@Data
public class CampaignsSitiosDTO implements Serializable {


    private List<Campaings> campaignEntities;
    private List<Sitios> siteEntities;

    public CampaignsSitiosDTO() {
    }

    public CampaignsSitiosDTO(List<Campaings> campaignEntities, List<Sitios> siteEntities) {
        this.campaignEntities = campaignEntities;
        this.siteEntities = siteEntities;
    }

    public List<Campaings> getCampaignEntities() {
        return campaignEntities;
    }

    public void setCampaignEntities(List<Campaings> campaignEntities) {
        this.campaignEntities = campaignEntities;
    }

    public List<Sitios> getSiteEntities() {
        return siteEntities;
    }

    public void setSiteEntities(List<Sitios> siteEntities) {
        this.siteEntities = siteEntities;
    }
}
