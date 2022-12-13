package com.md4_casestudy_furame.service.impl.contractService;

import com.md4_casestudy_furame.model.contract.ContractDetail;
import com.md4_casestudy_furame.repository.contract.IContractDetailRepository;
import com.md4_casestudy_furame.service.IGeneralService;
import com.md4_casestudy_furame.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository;


    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public Optional<ContractDetail> findById(int id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(int id) {
        contractDetailRepository.deleteById(id);
    }
}
