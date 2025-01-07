package com.comfandi.bono.recompra.batch.bonos.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.comfandi.bono.recompra.batch.bonos.entities.Campaings;
import com.comfandi.bono.recompra.batch.bonos.entities.Sitios;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SitiosResponseDTO {

	private List<Sitios> sitios;

	public List<Sitios> getSites() {
		return sitios;
	}

	private UUID id;
    @JsonProperty("name")
	private String name;
    @JsonProperty("city")
	private String city;
	@JsonProperty("isEnabled")
    private boolean isenabled;	
    @JsonProperty("createdAt")
	private LocalDate createdat;
    @JsonProperty("updatedAt")
	private LocalDate updatedat;
	

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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isIsenabled() {
		return isenabled;
	}
	public void setIsenabled(boolean isenabled) {
		this.isenabled = isenabled;
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

}
