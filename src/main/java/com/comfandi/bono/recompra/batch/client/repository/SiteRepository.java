package com.comfandi.bono.recompra.batch.client.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comfandi.bono.recompra.batch.bonos.entities.Sitios;

@Repository
public interface SiteRepository extends JpaRepository<Sitios, UUID> {

}
