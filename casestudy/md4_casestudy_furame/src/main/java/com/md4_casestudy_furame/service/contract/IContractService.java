package com.md4_casestudy_furame.service.contract;

import com.md4_casestudy_furame.dto.ContractDto;
import com.md4_casestudy_furame.model.contract.Contract;
import com.md4_casestudy_furame.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService extends IGeneralService<Contract> {

    Page<Contract> findAllContract(Pageable pageable);
    Page<Contract> findAll(Pageable pageable);

}
