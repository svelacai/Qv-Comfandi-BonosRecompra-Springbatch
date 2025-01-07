package com.comfandi.bono.recompra.batch.bonos.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "request")
public class Request {

    @Id
    private UUID id;

    @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "createdAt")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "campaignId", referencedColumnName = "id")
 //   @Convert(converter = UUIDToCampaignConverter.class)  // Aplicamos el Convert
    private Campaings campaign;

    @Column(name = "userDocument")
    private String userDocument;

    @Column(name = "userDocumentType")
    private String userDocumentType;

    @Column(name = "data")
    private String data;

}


/*
@Data
@Entity
@Table(name = "request")
public class Request {

    @Id
    private UUID id;

    @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "campaignId")
    @ManyToOne
    private UUID campaignId;

    @Column(name = "userDocument")
    private String userDocument;

    @Column(name = "userDocumentType")
    private String userDocumentType;

    @Column(name = "data")
    private String data;

}
*/