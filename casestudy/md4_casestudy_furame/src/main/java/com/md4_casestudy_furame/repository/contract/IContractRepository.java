package com.md4_casestudy_furame.repository.contract;

import com.md4_casestudy_furame.dto.ContractDto;
import com.md4_casestudy_furame.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IContractRepository extends JpaRepository<Contract, Integer> {

//    @Query(value = "select * from `contract`  where status = 1 order by id desc ", nativeQuery = true,
//            countQuery = "select * from (select * from `contract`  where status = 1 order by id desc) as ctr")
//    Page<Contract> findAllContract(Pageable pageable);

    @Query(value = "select * from `contract`  where status = 0 order by id desc ", nativeQuery = true)
    Page<Contract> findAllContract(Pageable pageable);
}
