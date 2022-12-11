package com.md4_casestudy_furame.repository.facility;

import com.md4_casestudy_furame.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select f.* " +
            "from `facility` f " +
            "join `facility_type` ft on f.facility_type_id = ft.id " +
            "join `rent_type` rt on f.rent_type_id = rt.id " +
            "where f.name like concat('%', :name,'%') " +
                "and ft.name like concat('%', :facilityType,'%') " +
                "and rt.name like concat('%', :rentType,'%') " +
                "and f.status=0 " +
            "order by f.id desc ",nativeQuery = true)
    Page<Facility> findByNameFacility(Pageable pageable,
                                      @Param("name") String name,
                                      @Param("facilityType") String facilityType,
                                      @Param("rentType") String rentType);

    @Transactional
    @Modifying
    @Query(value = "select `facility` " +
            "set status=1 " +
            "where id=:id",nativeQuery = true)
    void delete(int id);

}
