package com.md4_casestudy_furame.service.impl.contractService;

import com.md4_casestudy_furame.model.contract.AttachFacility;
import com.md4_casestudy_furame.repository.contract.IAttachFacilityRepository;
import com.md4_casestudy_furame.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public Optional<AttachFacility> findById(int id) {
        return attachFacilityRepository.findById(id);
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }

    @Override
    public void remove(int id) {
        attachFacilityRepository.deleteById(id);
    }
}
