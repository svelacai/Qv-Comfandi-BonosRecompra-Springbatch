package com.comfandi.bono.recompra.batch.bonos.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "salereport")
public class SaleReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "createdat")
    private LocalDate createdAt;

    @ManyToOne // Relación Many-to-One con Store
    @JoinColumn(name = "storeId", referencedColumnName = "id")
    private Sitios store; // Ahora estamos usando la entidad Store, no Long

    @Column(name = "store", nullable = false)
    private String storeName; // Aquí se puede cambiar el nombre según sea necesario.

    @Column(name = "transactiondate", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "transactionid", nullable = false)
    private Integer transactionId;

    @Column(name = "cashiernumber", nullable = false)
    private String cashierNumber;

    @Column(name = "cashierid", nullable = false)
    private Integer cashierId;

    @ManyToOne // Relación Many-to-One con ReCompraProduct
    @JoinColumn(name = "plu", referencedColumnName = "plu")
    private ReCompraProduct product;

    @Column(name = "productdescription", nullable = false)
    private String productDescription;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "unitprice", nullable = false)
    private Integer unitPrice;

    @Column(name = "totalvalue", nullable = false, precision = 19, scale = 2)
    private BigDecimal totalValue;

    @Column(name = "clientdocumenttype", nullable = false)
    private String clientDocumentType;

    @Column(name = "clientdocument", nullable = false)
    private Integer clientDocument;

    @Column(name = "clientcategory", nullable = false)
    private char clientCategory;    
}

/*
@Data
@Entity
@Table(name = "salereport")
public class SaleReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "createdat")
    private LocalDate createdAt;

    @Column(name = "storeid")
    @ManyToMany
    private Long storeId;

    @Column(name = "store", nullable = false)
    @ManyToMany
    private String store;

    @Column(name = "transactiondate", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "transactionid", nullable = false)
    private Integer transactionId;

    @Column(name = "cashiernumber", nullable = false)
    private String cashierNumber;

    @Column(name = "cashierid", nullable = false)
    private Integer cashierId;

    @Column(name = "plu", nullable = false)
    @ManyToMany
    private String plu;

    @Column(name = "productdescription", nullable = false)
    private String productDescription;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "unitprice", nullable = false)
    private Integer unitPrice;

    @Column(name = "totalvalue", nullable = false, precision = 19, scale = 2)
    private BigDecimal totalValue;

    @Column(name = "clientdocumenttype", nullable = false)
    private String clientDocumentType;

    @Column(name = "clientdocument", nullable = false)
    private Integer clientDocument;

    @Column(name = "clientcategory", nullable = false)
    private char clientCategory;	 
}
*/
