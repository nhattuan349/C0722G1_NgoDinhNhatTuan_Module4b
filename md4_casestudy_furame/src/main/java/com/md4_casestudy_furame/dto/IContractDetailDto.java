package com.md4_casestudy_furame.dto;

import com.md4_casestudy_furame.model.contract.AttachFacility;
import com.md4_casestudy_furame.model.contract.Contract;

public interface IContractDetailDto {

    String getNameDto();
    String getUnitDto();
    String getQuantityDto();
    String getStatusDto();
    String getCostDto();
}
