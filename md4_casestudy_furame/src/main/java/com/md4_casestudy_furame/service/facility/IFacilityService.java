package com.md4_casestudy_furame.service.facility;

import com.md4_casestudy_furame.model.facility.Facility;
import com.md4_casestudy_furame.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IFacilityService extends IGeneralService<Facility> {

    Page<Facility> findByNameFacility(Pageable pageable,String name, String facilityType,String rentType);
}
