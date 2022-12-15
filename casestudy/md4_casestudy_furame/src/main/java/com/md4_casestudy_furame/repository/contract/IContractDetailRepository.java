package com.md4_casestudy_furame.repository.contract;

import com.md4_casestudy_furame.dto.IContractDetailDto;
import com.md4_casestudy_furame.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    @Query(value = "select atf.name as nameDto, atf.unit as unitDto, " +
                            "sum(ifnull(ctrd.quanlity, 0)) as quantityDto, " +
                            "atf.status as statusDto, atf.cost as costDto " +
                    "from contract_detail ctrd " +
                    "join attach_facility atf on ctrd.attach_facility_id = atf.id " +
                    "where ctrd.contract_id =:idFind " +
                    "group by atf.id ", nativeQuery = true)
    List<IContractDetailDto> showAll(@Param("idFind") Integer id);

}
