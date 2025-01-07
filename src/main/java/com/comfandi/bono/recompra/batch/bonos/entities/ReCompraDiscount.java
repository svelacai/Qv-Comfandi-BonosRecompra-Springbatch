package com.comfandi.bono.recompra.batch.bonos.entities;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reCompraDiscount")
public class ReCompraDiscount {

    @Id
    private UUID id;
    
    @Column(name = "dt_creacion")
    private Instant dt_creacion;
    
    @ManyToOne // Relación con ReCompraProduct
    @JoinColumn(name = "campaingId", referencedColumnName = "id") // Asocia con la campaña
    private ReCompraProduct reCompraProduct; // Relación Many-to-One con ReCompraProduct
    
    @Column(name = "valuePerCategory")
    private String valuePerCategory;
    
    @Column(name = "minValue")
    private Long minValue;
    
    @Column(name = "maxValue")
    private Long maxValue;
    
    @Column(name = "maxBonusAmount")
    private Long maxBonusAmount;
    
    @Column(name = "currentTotalAccumulatedBonus")
    private Long currentTotalAccumulatedBonus;
}

/*
@Data
@Entity
@Table(name = "reCompraDiscount")
public class ReCompraDiscount {

	@Id
    private UUID id;
	
	@Column(name = "dt_creacion")
    private Instant dt_creacion;
	
	@Column(name = "campaingId")
	@OneToMany
    private UUID campaingId;
	
	@Column(name = "valuePerCategory")
    private String valuePerCategory;
	
	@Column(name = "minValue")
    private Long minValue;
	
	@Column(name = "maxValue")
    private Long maxValue;
	
	@Column(name = "maxBonusAmount")
    private Long maxBonusAmount;
	
	@Column(name = "currentTotalAccumulatedBonus")
    private Long currentTotalAccumulatedBonus;
}*/
