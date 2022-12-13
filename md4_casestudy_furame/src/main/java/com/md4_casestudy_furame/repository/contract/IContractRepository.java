package com.md4_casestudy_furame.repository.contract;

import com.md4_casestudy_furame.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select *" +
            " from `contract` " +
            " where status = 1", nativeQuery = true)
    Page<Contract> getList(Pageable pageable);


}
