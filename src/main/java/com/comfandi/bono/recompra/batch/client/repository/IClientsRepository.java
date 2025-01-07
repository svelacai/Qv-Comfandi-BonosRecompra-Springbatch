package com.comfandi.bono.recompra.batch.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comfandi.bono.recompra.batch.client.enties.Client;

//@EnableJpaRepositories
//@Repository
//public interface IClientsRepository extends JpaRepository<Client, Long> {
//	
//    @Query("SELECT c FROM Client c WHERE c.state = :state AND c.clientCategory != :category")
//   public List<Client> findByStateAndCategory(@Param("state") String state, @Param("category") String category);
//}
