package com.comfandi.bono.recompra.batch.bonos.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sitios")
public class Sitios {

	@Id
	private UUID id;
	private String name;
	private String city;
	private boolean isenabled;
	private LocalDate createdat;
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
