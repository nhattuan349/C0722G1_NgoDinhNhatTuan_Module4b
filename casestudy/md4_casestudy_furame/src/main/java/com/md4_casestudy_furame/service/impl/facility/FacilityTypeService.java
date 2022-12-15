package com.md4_casestudy_furame.service.impl.facility;

import com.md4_casestudy_furame.model.facility.FacilityType;
import com.md4_casestudy_furame.repository.facility.IFacilityTypeRepository;
import com.md4_casestudy_furame.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public Optional<FacilityType> findById(int id) {
        return facilityTypeRepository.findById(id);
    }

    @Override
    public void save(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }

    @Override
    public void remove(int id) {
        facilityTypeRepository.deleteById(id);
    }
}
