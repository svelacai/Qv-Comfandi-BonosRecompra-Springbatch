package com.comfandi.bono.recompra.batch.client.http;

import com.comfandi.bono.recompra.batch.bonos.dto.SitiosResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class XandarSites {

    private final RestTemplate restTemplate;
    private static final String URL = "https://xandar.subsidioscomfandi.com.co/site-capacity/sites";

    // Inyección de RestTemplate
    public XandarSites(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método para obtener los sitios
    public List<SitiosResponseDTO> getService2Data(String token) {
        // Configuración de los headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear la solicitud HTTP
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        // Realizamos la solicitud con el RestTemplate
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                URL, 
                HttpMethod.GET, 
                requestEntity, 
                new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        );

        // Obtenemos la lista de mapas desde la respuesta
        List<Map<String, Object>> responseBody = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());  

        return objectMapper.convertValue(responseBody, objectMapper.getTypeFactory().constructCollectionType(List.class, SitiosResponseDTO.class));
    }
}
