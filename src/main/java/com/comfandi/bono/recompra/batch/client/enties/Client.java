package com.comfandi.bono.recompra.batch.client.enties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client {

	@Id
    private Long id;
    private String name;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "client_document_type")
    private String clientDocumentType;
    
    @Column(name = "client_document")
    private Long clientDocument;
    
    @Column(name = "client_category")
    private char clientCategory;
    
    private String state;
}
