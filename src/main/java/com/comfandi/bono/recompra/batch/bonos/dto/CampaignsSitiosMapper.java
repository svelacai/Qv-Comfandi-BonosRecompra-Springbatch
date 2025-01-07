package com.comfandi.bono.recompra.batch.bonos.dto;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.bonos.entities.Campaings;
import com.comfandi.bono.recompra.batch.bonos.entities.Sitios;

@Component
public class CampaignsSitiosMapper {

	public List<Campaings> mapToCampaigns(CampaingResponseDTO response) {
		return response.getCampaigns().stream().map(campaign -> {
			Campaings campaignsEntity = new Campaings();
			campaignsEntity.setId(campaign.getId());
			campaignsEntity.setName(campaign.getName());
			campaignsEntity.setCampaigntypeid(campaign.getCampaigntypeid());
			campaignsEntity.setStartdate(campaign.getStartdate());
			campaignsEntity.setEnddate(campaign.getEnddate());
			campaignsEntity.setClaimstartdate(campaign.getClaimstartdate());
			campaignsEntity.setClaimenddate(campaign.getClaimenddate());
			campaignsEntity.setCampaignconfigid(campaign.getCampaignconfigid());
			campaignsEntity.setSegment(campaign.getSegment());
			campaignsEntity.setCreatedat(campaign.getCreatedat());
			campaignsEntity.setUpdatedat(campaign.getUpdatedat());
			return campaignsEntity;
		}).collect(Collectors.toList());
	}

	



	public List<Sitios> mapToSitios(List<SitiosResponseDTO> responseList) {
		List<Sitios> sitiosList = new ArrayList<>();

		// Iteramos sobre cada SitiosResponseDTO
		for (SitiosResponseDTO site : responseList) {
			Sitios sitiosEntity = new Sitios();

			// Asignación de cada campo
			sitiosEntity.setId(site.getId());
			sitiosEntity.setName(site.getName());
			sitiosEntity.setCity(site.getCity());
			sitiosEntity.setIsenabled(site.isIsenabled());
			sitiosEntity.setCreatedat(site.getCreatedat());
			sitiosEntity.setUpdatedat(site.getUpdatedat());

			sitiosList.add(sitiosEntity);
		}

		return sitiosList;
	}

}
