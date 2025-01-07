package com.comfandi.bono.recompra.batch.bonos.entities;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
/*
@Data
@Entity
@Table(name = "recompraproduct")
public class ReCompraProduct {

    @Id
    private UUID id;
    
    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;
    
    @ManyToOne
    @JoinColumn(name = "campaignId", referencedColumnName = "id")
   // @Convert(converter = UUIDToCampaignConverter.class)  // Aplicamos el Convert
    private UUID campaign;

    @Column(name = "plu", nullable = false, length = 50)
    private String PLU;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
}
*/


@Data
@Entity
@Table(name = "recompraproduct")
public class ReCompraProduct {

    @Id
    private UUID id;
    
    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "campaignId", nullable = false)
    private UUID campaignId;

    @Column(name = "plu", nullable = false, length = 50)
    private String PLU;

    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;

}

