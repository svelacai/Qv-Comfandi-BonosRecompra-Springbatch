package com.comfandi.bono.recompra.batch.bonos.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comfandi.bono.recompra.batch.bonos.entities.Request;

@Repository
public interface IRequestRepository extends JpaRepository<Request, UUID> {

}
