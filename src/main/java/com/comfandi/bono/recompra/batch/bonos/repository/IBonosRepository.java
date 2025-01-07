package com.comfandi.bono.recompra.batch.bonos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comfandi.bono.recompra.batch.bonos.dto.BonosDTO;

/*
@Repository
public interface IBonosRepository extends JpaRepository<BonosDTO, Long> {

    @Query(nativeQuery = true, value = "SELECT sp.clientdocumenttype, sp.clientdocument, sp.plu, sp.descripcionProduct, st.name, sp.clientcategory, cp.uuidCampanId " +
            "FROM SaleReport sp " +
            "JOIN RecompreProducts rc ON rc.plu = sp.plu " +
            "JOIN Campaigns cp ON rc.campaignId = cp.id " +
            "JOIN Sitios st ON st.name = sp.store " +
            "WHERE rc.campaignId = :campaignId " +
            "AND sp.plu = :plu " +
            "AND cp.endDate <= :endDate")
    List<Object[]> findBonosDTO(@Param("campaignId") String campaignId,
                                @Param("plu") String plu,
                                @Param("endDate") java.util.Date endDate);
}
*/
	
	
/*
    @Query(value = "SELECT sp.clientdocumenttype, sp.clientdocument, sp.plu, sp.productdescription, st.name, sp.clientcategory, cp.id "
            + "FROM SaleReport sp "
            + "JOIN RecompreProducts rc ON rc.plu = sp.plu "
            + "JOIN Campaigns cp ON rc.campaignId = cp.id "
            + "JOIN Sitios st ON st.name = sp.store "
            + "WHERE rc.campaignId = :campaignId "
            + "AND sp.plu = :plu "
            + "AND cp.endDate <= :endDate", nativeQuery = true)
    */
/*    public List<Object[]> findBonosDTO(@Param("campaignId") String campaignId, @Param("plu") String plu, @Param("endDate") Date endDate);  
}
*/
