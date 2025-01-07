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
@Table(name = "redemptioncode")
public class RedemptionCode {

    @Id
    private UUID id;
    
    @Column(name = "createdAt")
    private Date createdAt;
    
    @Column(name = "updateAt")
    private Date updateAt;
    
    @ManyToOne
    @JoinColumn(name = "campaignId", referencedColumnName = "id")
   // @Convert(converter = UUIDToCampaignConverter.class)  // Aplicamos el Convert
    private Campaings campaign;
    
    @ManyToOne // Relación Many-to-One con Request
    @JoinColumn(name = "requestId", referencedColumnName = "id")
    private Request request;

    @Column(name = "redemptionId")
    private String redemptionId;
    
    @Column(name = "siteId")
    private String siteId; 
    
    @Column(name = "siteName")
    private String siteName; 
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "documentType")
    private String documentType;
    
    @Column(name = "document")
    private String document;
    
    @Column(name = "redemptionDate")
    private Date redemptionDate;
    
    @Column(name = "validationDate")
    private Date validationDate;
    
    @Column(name = "validationUser")
    private String validationUser;
    
    @Column(name = "validationSiteId")
    private UUID validationSiteId;
    
    @Column(name = "validationSiteName")
    private String validationSiteName;

    @Column(name = "isActive")
    private boolean isActive;
}

/*
@Data
@Entity
@Table(name = "redemptioncode")
public class RedemptionCode {

	@Id
    private UUID id;
	
	@Column(name = "createdAt")
    private Date createdAt;
	
	@Column(name = "updateAt")
    private Date updateAt;
	
	@Column(name = "campaingId")
    private UUID campaingId;
	
    @Column(name = "requestId")
    private UUID requestId; 
    
    @Column(name = "redemptionId")
    private String redemptionId;
    
    @Column(name = "siteId")
    private String siteId; 
    
    @Column(name = "siteName")
    private String siteName; 
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "documentType")
    private String documentType;
    
    @Column(name = "document")
    private String document;
    
    @Column(name = "redemptionDate")
    private Date redemptionDate;
    
    @Column(name = "validationDate")
    private Date validationDate;
    
    @Column(name = "validationUser")
    private String validationUser;
    
    @Column(name = "validationSiteId")
    private UUID validationSiteId;
    
    @Column(name = "validationSiteName")
    private String validationSiteName;
 
    @Column(name = "isActive")
    private boolean isActive;
}
*/
