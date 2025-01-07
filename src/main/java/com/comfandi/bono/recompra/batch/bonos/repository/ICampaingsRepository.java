package com.comfandi.bono.recompra.batch.bonos.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comfandi.bono.recompra.batch.bonos.entities.Campaings;

public interface ICampaingsRepository extends JpaRepository<Campaings, UUID> {
	
    @Query("SELECT c FROM Campaings c WHERE c.name = :name")
    Campaings findCampaignById(@Param("name") String name);
    
    @Query(value = "SELECT * FROM Campaings", nativeQuery = true)
    public List<Campaings> findAll();
    
    

}
