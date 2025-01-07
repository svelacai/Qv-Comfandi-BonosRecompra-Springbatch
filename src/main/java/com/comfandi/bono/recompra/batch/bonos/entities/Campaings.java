package com.comfandi.bono.recompra.batch.bonos.entities;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "campaigns")
public class Campaings {
	
	@Id
	private UUID Id;
    @JsonProperty("name")
	private String name;
    @JsonProperty("campaignTypeId")
	private Integer campaigntypeid;
    @JsonProperty("startDate")
	private LocalDate startdate;
    @JsonProperty("endDate")
	private LocalDate enddate;
    @JsonProperty("claimStartDate")
	private LocalDate claimstartdate;
    @JsonProperty("claimEndDate")
	private LocalDate claimenddate;
    @JsonProperty("campaignConfigId")
	private Integer campaignconfigid;
    @JsonProperty("segment")
	private String segment;
    @JsonProperty("createdAt")
	private LocalDate createdat;
    @JsonProperty("updatedAt")
	private LocalDate updatedat;



	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public LocalDate getCreatedat() {
		return createdat;
	}
	public void setCreatedat(LocalDate createdat) {
		this.createdat = createdat;
	}
	public LocalDate getUpdatedat() {
		return updatedat;
	}
	public void setUpdatedat(LocalDate updatedat) {
		this.updatedat = updatedat;
	}
	public UUID getId() {
		return Id;
	}
	public void setId(UUID id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCampaigntypeid() {
		return campaigntypeid;
	}
	public void setCampaigntypeid(Integer campaigntypeid) {
		this.campaigntypeid = campaigntypeid;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	public LocalDate getClaimstartdate() {
		return claimstartdate;
	}
	public void setClaimstartdate(LocalDate claimstartdate) {
		this.claimstartdate = claimstartdate;
	}
	public LocalDate getClaimenddate() {
		return claimenddate;
	}
	public void setClaimenddate(LocalDate claimenddate) {
		this.claimenddate = claimenddate;
	}
	public Integer getCampaignconfigid() {
		return campaignconfigid;
	}
	public void setCampaignconfigid(Integer campaignconfigid) {
		this.campaignconfigid = campaignconfigid;
	}
	
	
}