package com.md4_casestudy_furame.repository.contract;

import com.md4_casestudy_furame.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
}
