package com.comfandi.bono.recompra.batch.steps;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.bonos.dto.AuthResponseDTO;
import com.comfandi.bono.recompra.batch.bonos.dto.CampaignsSitiosDTO;
import com.comfandi.bono.recompra.batch.bonos.dto.CampaignsSitiosMapper;
import com.comfandi.bono.recompra.batch.bonos.dto.CampaingResponseDTO;
import com.comfandi.bono.recompra.batch.bonos.dto.SitiosResponseDTO;
import com.comfandi.bono.recompra.batch.bonos.entities.Campaings;
import com.comfandi.bono.recompra.batch.bonos.entities.Sitios;
import com.comfandi.bono.recompra.batch.bonos.repository.ICampaingsRepository;
import com.comfandi.bono.recompra.batch.client.http.AuthService;
import com.comfandi.bono.recompra.batch.client.http.XandarCampaigns;
import com.comfandi.bono.recompra.batch.client.http.XandarSites;
import com.comfandi.bono.recompra.batch.client.repository.CampaignRepository;
import com.comfandi.bono.recompra.batch.client.repository.SiteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CampaignsSitioReader implements ItemReader<CampaignsSitiosDTO> {

	private static final Logger logger = LoggerFactory.getLogger(CampaignsSitioReader.class);

	private AuthService authService;

	private XandarCampaigns xandarCampaigns;

	private XandarSites xandarSites;
	
	    private CampaignRepository campaingsRepository; 

	    private SiteRepository sitiosRepository;
	

	public CampaignsSitioReader(AuthService authService, XandarCampaigns xandarCampaigns, XandarSites xandarSites, CampaignRepository campaingsRepository ,SiteRepository sitiosRepository)
			throws Exception {
		this.authService = authService;
		this.xandarCampaigns = xandarCampaigns;
		this.xandarSites = xandarSites;
		this.campaingsRepository = campaingsRepository;
		this.sitiosRepository = sitiosRepository;


		logger.info("------------->>>>>  Ejecutando la clase CampaignsSitioReader()  <<<<<-------------------");
		read();
	}

	private CampaignsSitiosMapper mapper = new CampaignsSitiosMapper();

	@Override
	public CampaignsSitiosDTO read() throws Exception {
		logger.info("------------->>>>>  Ejecutando el metodo CampaignsSitioReader()  <<<<<-------------------");
		AuthResponseDTO authResponse;
		String username = "appuserqvision";
		String password = "9Zi+8\\_9Dhg&";
		try {
			authResponse = authService.getAuthToken(username, password);

		} catch (Exception e) {
			logger.error("Error al obtener el token: ", e);
			return null; 
		}

		if (authResponse == null || authResponse.getAccessToken() == null) {
			logger.error("Error consumiendo token de login");
			return null; 
		}

		String token = "Bearer " + authResponse.getAccessToken();

		CampaingResponseDTO campaignsData;
		List<SitiosResponseDTO> sitesData;

		try {
			campaignsData = xandarCampaigns.getService1Data(token);
			sitesData = xandarSites.getService2Data(token);
		} catch (Exception e) {
			logger.error("Error al consumir los servicios: ", e);
			return null; 
		}
		
	
		List<Campaings> campaigns = mapper.mapToCampaigns(campaignsData);
		List<Sitios> sitios = mapper.mapToSitios(sitesData);
		
        saveEntities(campaigns, sitios);


		CampaignsSitiosDTO campaignsSitiosDTO = new CampaignsSitiosDTO();
		campaignsSitiosDTO.setCampaignEntities(campaigns);
		campaignsSitiosDTO.setSiteEntities(sitios);
		

		return campaignsSitiosDTO;
	}
	
	 private void saveEntities(List<Campaings> campaigns, List<Sitios> sitios) {
	        try {
	            if (campaigns != null && !campaigns.isEmpty()) {
	                campaingsRepository.saveAll(campaigns);  // Insertar todas las campañas
	                logger.info("Campañas guardadas exitosamente.");
	            }

	            if (sitios != null && !sitios.isEmpty()) {
	                sitiosRepository.saveAll(sitios);  // Insertar todos los sitios
	                logger.info("Sitios guardados exitosamente.");
	            }
	        } catch (Exception e) {
	            logger.error("Error al guardar las entidades en la base de datos: ", e);
	        }
	    }
	

}
