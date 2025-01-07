package com.comfandi.bono.recompra.batch.bonos.dto;

import java.io.Serializable;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.comfandi.bono.recompra.batch.bono.steps.BonoDtoItemReader;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.Data;

@Data
@SqlResultSetMapping(name = "BonosDTOMapping",
					classes = @ConstructorResult(
							targetClass = BonosDTO.class,
							columns = {
									@ColumnResult(name = "clientdocumenttype"),
									@ColumnResult(name = "clientdocument"),
									@ColumnResult(name = "plu"),
									@ColumnResult(name = "descripcionProduct"),
									@ColumnResult(name = "name"),
									@ColumnResult(name = "clientcategory"),
									@ColumnResult(name = "uuidCampanId")
							}
							
					)
		)
public class BonosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(BonoDtoItemReader.class);

	private String clientdocumenttype;
	private Long clientdocument;
	private String plu;
	private String descripcionProduct;
	private String name;
	private String clientcategory;
	private UUID uuidCampanId;

	public BonosDTO(String clientdocumenttype, Long clientdocument, String plu, String descripcionProduct, String name,
			String clientcategory, UUID uuidCampanId) {
		super();
		this.clientdocumenttype = clientdocumenttype;
		this.clientdocument = clientdocument;
		this.plu = plu;
		this.descripcionProduct = descripcionProduct;
		this.name = name;
		this.clientcategory = clientcategory;
		this.uuidCampanId = uuidCampanId;
	}

	public BonosDTO() {
	
	}

	public String getClientdocumenttype() {
		return clientdocumenttype;
	}

	public void setClientdocumenttype(String clientdocumenttype) {
		this.clientdocumenttype = clientdocumenttype;
	}

	public Long getClientdocument() {
		return clientdocument;
	}

	public void setClientdocument(Long clientdocument) {
		this.clientdocument = clientdocument;
	}

	public String getPlu() {
		return plu;
	}

	public void setPlu(String plu) {
		this.plu = plu;
	}

	public String getDescripcionProduct() {
		return descripcionProduct;
	}

	public void setDescripcionProduct(String descripcionProduct) {
		this.descripcionProduct = descripcionProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientcategory() {
		return clientcategory;
	}

	public void setClientcategory(String clientcategory) {
		this.clientcategory = clientcategory;
	}

	public UUID getUuidCampanId() {
		return uuidCampanId;
	}

	public void setUuidCampanId(UUID uuidCampanId) {
		this.uuidCampanId = uuidCampanId;
	}
	
	
}
