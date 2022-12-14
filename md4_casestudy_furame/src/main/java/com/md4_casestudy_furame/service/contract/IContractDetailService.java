package com.md4_casestudy_furame.service.contract;

import com.md4_casestudy_furame.dto.IContractDetailDto;
import com.md4_casestudy_furame.model.contract.ContractDetail;
import com.md4_casestudy_furame.service.IGeneralService;
import com.md4_casestudy_furame.service.impl.contractService.ContractService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailService extends IGeneralService<ContractDetail> {

    List<IContractDetailDto> showAll( Integer id);

}
