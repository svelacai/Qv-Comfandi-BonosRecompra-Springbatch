package com.comfandi.bono.recompra.batch.bonos.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.comfandi.bono.recompra.batch.bonos.entities.Campaings;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)  // Ignorar campos desconocidos
public class CampaingResponseDTO {
    private List<Campaings> campaigns;
    
	
	public List<Campaings> getCampaigns() {
		return campaigns;
	}

    private int trecords;
    
    private UUID id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("campaignTypeId")
    private int campaignTypeId;
    @JsonProperty("startDate")
    private LocalDate startDate;
    @JsonProperty("endDate")
    private LocalDate endDate;
    @JsonProperty("claimStartDate")
    private LocalDate claimStartDate;
    @JsonProperty("claimEndDate")
    private String claimEndDate;
    @JsonProperty("campaignConfigId")
    private int campaignConfigId;
    @JsonProperty("segment")
    private String segment;
    @JsonProperty("createdAt")
    private LocalDate createdAt;
    @JsonProperty("updatedAt")
    private LocalDate updatedAt;
    
    private CampaignConfigurations campaignConfigurations;
    private CampaignType campaignType;

    // Clases anidadas
    @Data
    public static class CampaignConfigurations {
        private int id;
        private String description;
        private String info;
        private String termsAndConditions;
        private String image;
        private Object configuration;
        private int recipient;
        private int aditionalBenefit;
        private boolean isEnabled;
        private LocalDate createdAt;
        private LocalDate updatedAt;
    }

    @Data
    public static class CampaignType {
        private int id;
        private String name;
        private String description;
        private boolean isEnabled;
        private LocalDate createdAt;
        private LocalDate updatedAt;
    }
    



	public int getTrecords() {
		return trecords;
	}

	public void setTrecords(int trecords) {
		this.trecords = trecords;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCampaignTypeId() {
		return campaignTypeId;
	}

	public void setCampaignTypeId(int campaignTypeId) {
		this.campaignTypeId = campaignTypeId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getClaimStartDate() {
		return claimStartDate;
	}

	public void setClaimStartDate(LocalDate claimStartDate) {
		this.claimStartDate = claimStartDate;
	}

	public String getClaimEndDate() {
		return claimEndDate;
	}

	public void setClaimEndDate(String claimEndDate) {
		this.claimEndDate = claimEndDate;
	}

	public int getCampaignConfigId() {
		return campaignConfigId;
	}

	public void setCampaignConfigId(int campaignConfigId) {
		this.campaignConfigId = campaignConfigId;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
    
}
