package com.comfandi.bono.recompra.batch.client.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.comfandi.bono.recompra.batch.bonos.dto.AuthResponseDTO;

@Service
public class AuthService {

    private final RestTemplate restTemplate;

    public AuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AuthResponseDTO getAuthToken(String username, String password) {
        String url = "https://iam.comfandi.com.co/auth/realms/comfandi/protocol/openid-connect/token";

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", "app-comfandi");
        body.add("scope", "openid");
        body.add("grant_type", "password");
        body.add("username", username);
        body.add("password", password);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<AuthResponseDTO> response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, AuthResponseDTO.class);

        return response.getBody();
    }
}
