package com.comfandi.bono.recompra.batch.services.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.comfandi.bono.recompra.batch.bono.steps.FactoryStepBonos;
import com.comfandi.bono.recompra.batch.bonos.entities.Campaings;
import com.comfandi.bono.recompra.batch.util.Constantes;

public class CampaingsServicesImpl {
	private static final Logger logger = LoggerFactory.getLogger(FactoryStepBonos.class);

	private static final String URL = Constantes.ENDPOINT_CAMPAING;

	public static void main(String[] args) {
		String jsonResponse;
		try {
			logger.info("----------------------Inicia --------------------------");

			jsonResponse = getCampaignsByTypeAndState(3, true);

			List<Campaings> campaigns = mockCampaing(jsonResponse);

			// Imprimir los resultados
			campaigns.forEach(campaign -> {
				System.out.println("ID: " + campaign.getId());
				System.out.println("Nombre: " + campaign.getName());
				System.out.println("Fecha de Inicio: " + campaign.getStartdate());
				System.out.println("Fecha de Fin: " + campaign.getEnddate());
				System.out.println("Config id: " + campaign.getCampaignconfigid());
				System.out.println("Fecha inicio 2 : " + campaign.getClaimstartdate());
				System.out.println("Fecha fin 2 : " + campaign.getClaimenddate());
				System.out.println();
			});
			logger.info("----------------------Fin --------------------------");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static String getCampaings(Integer campaignType) throws Exception {
		String listCampings = getCampaignsByTypeAndState(campaignType, true);
		return listCampings;
	}

	public static String getCampaignsByTypeAndState(Integer campaignType, boolean all) throws Exception {

		HttpClient client = HttpClient.newHttpClient();
		List<Campaings> listTypeCampaings = new ArrayList<>();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).header("Accept", "application/json")
				.GET().build();
		logger.info("---> "+request);

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		logger.info("---> "+response);
		return response.body();
	}

	// Mock capañas
	public static List<Campaings> mockCampaing(String jsonResponse) {

		List<Campaings> campaigns = new ArrayList<>();
		try {
			JSONObject jsonObject  = new JSONObject(jsonResponse);
			jsonObject.put("campaigns", new JSONArray());
			
			JSONArray campaignsArray = jsonObject.getJSONArray("campaigns"); 
			DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

            for (int i = 0; i < campaignsArray.length(); i++) {
                JSONObject campaignJson = campaignsArray.getJSONObject(i);
                Campaings campaign = new Campaings();
                String campaignIdString = campaignJson.getString("id");
                UUID id = UUID.fromString(campaignIdString); // 
                campaign.setId(id);
                campaign.setName(campaignJson.getString("name"));
                String startDateString = campaignJson.getString("startDate");
                ZonedDateTime startDate = ZonedDateTime.parse(startDateString, formatter);
                String endDateString = campaignJson.getString("endDate");
                ZonedDateTime endDate = ZonedDateTime.parse(endDateString, formatter);
                String claimStartDateString = campaignJson.getString("claimStartDate");
                ZonedDateTime claimStartDate = ZonedDateTime.parse(claimStartDateString, formatter);
                String claimEndDateString = campaignJson.getString("claimEndDate");
                ZonedDateTime claimEndDate = ZonedDateTime.parse(claimEndDateString, formatter);

                campaign.setStartdate(startDate.toLocalDate()); 
                campaign.setEnddate(endDate.toLocalDate());
                campaign.setClaimstartdate(claimStartDate.toLocalDate());
                campaign.setClaimenddate(claimEndDate.toLocalDate());
                campaign.setCampaignconfigid(campaignJson.getInt("campaignConfigId"));
                campaigns.add(campaign);
            }
		} catch (Exception e) {
			logger.info("---->"+e);
		}
		return campaigns;
	}
}

//		try {
//			
//			
//
//			//HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//			HttpResponse<String> response = mockCampaing(request, HttpResponse.BodyHandlers.ofString() );
//			String responseBody = response.body();
//
//			JSONObject jsonResponse = new JSONObject(responseBody);
//			JSONArray campaigns = jsonResponse.getJSONArray("campaigns");			
//			//JSONArray campaigns = jsonResponse.getJSONArray("campaigns");
//		
//
//			IntStream.range(0, campaigns.length()).mapToObj(i -> campaigns.getJSONObject(i)).forEach(campaign -> {
//				String campaignName = campaign.getString("name");
//				String campaignStartDate = campaign.getString("startDate");
//				String campaignEndDate = campaign.getString("endDate");
//
//				System.out.println("Nombre de la campaña: " + campaignName);
//				System.out.println("Fecha de inicio: " + campaignStartDate);
//				System.out.println("Fecha de fin: " + campaignEndDate);
//
//			});
//
//		} catch (Exception e) {
//
//		}
//
//		return listTypeCampaings;
//	}
//	
