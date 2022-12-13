package com.md4_casestudy_furame.repository.contract;

import com.md4_casestudy_furame.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
}
