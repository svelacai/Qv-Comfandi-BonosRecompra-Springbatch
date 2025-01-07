package com.comfandi.bono.recompra.batch.client.http;

import com.comfandi.bono.recompra.batch.bonos.dto.CampaingResponseDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class XandarCampaigns {

	private final RestTemplate restTemplate;

	private static final String URL = "https://xandar.subsidioscomfandi.com.co/campaigns";

	public XandarCampaigns(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public CampaingResponseDTO getService1Data(String token) {
		// Configurar los Headers
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<CampaingResponseDTO> response = restTemplate.exchange(URL, HttpMethod.GET, requestEntity,
				CampaingResponseDTO.class);

		return response.getBody();
	}
}
