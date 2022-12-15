package com.md4_casestudy_furame.service.impl.facility;

import com.md4_casestudy_furame.model.facility.Facility;
import com.md4_casestudy_furame.repository.facility.IFacilityRepository;
import com.md4_casestudy_furame.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;


    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> findByNameFacility(Pageable pageable, String name, String facilityType, String rentType) {
        return facilityRepository.findByNameFacility(pageable, name, facilityType, rentType);
    }
}
