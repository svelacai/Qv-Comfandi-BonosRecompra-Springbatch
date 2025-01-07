package com.comfandi.bono.recompra.batch.steps;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.comfandi.bono.recompra.batch.bonos.dto.AuthResponseDTO;
import com.comfandi.bono.recompra.batch.bonos.dto.CampaignsSitiosDTO;
import com.comfandi.bono.recompra.batch.bonos.dto.CampaingResponseDTO;
import com.comfandi.bono.recompra.batch.bonos.dto.SitiosResponseDTO;
import com.comfandi.bono.recompra.batch.client.http.AuthService;
import com.comfandi.bono.recompra.batch.client.http.XandarCampaigns;
import com.comfandi.bono.recompra.batch.client.http.XandarSites;
import com.comfandi.bono.recompra.batch.client.repository.CampaignRepository;
import com.comfandi.bono.recompra.batch.client.repository.SiteRepository;

class CampaignsSitioReaderTest {

    @Mock
    private AuthService authService;

    @Mock
    private XandarCampaigns xandarCampaigns;

    @Mock
    private XandarSites xandarSites;

    @Mock
    private CampaignRepository campaignRepository;

    @Mock
    private SiteRepository siteRepository;

    @InjectMocks
    private CampaignsSitioReader campaignsSitioReader;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    
    @Test
    void testRead_authenticationFailure() throws Exception {
        when(authService.getAuthToken(anyString(),anyString())).thenThrow(new RuntimeException("Auth error"));

        // Act
        CampaignsSitiosDTO result = campaignsSitioReader.read();

        // Assert
        assertNull(result);
        verifyNoInteractions(xandarCampaigns);
        verifyNoInteractions(xandarSites);
        verifyNoInteractions(campaignRepository);
        verifyNoInteractions(siteRepository);
    }

    @Test
    void testRead_serviceFailure() throws Exception {
        AuthResponseDTO authResponse = new AuthResponseDTO();
        authResponse.setAccessToken("fake-token");
        when(authService.getAuthToken(anyString(),anyString())).thenReturn(authResponse);

        when(xandarCampaigns.getService1Data("Bearer fake-token")).thenThrow(new RuntimeException("Service error"));

        // Act
        CampaignsSitiosDTO result = campaignsSitioReader.read();

        // Assert
        assertNull(result);
        verifyNoInteractions(siteRepository);
    }
}
