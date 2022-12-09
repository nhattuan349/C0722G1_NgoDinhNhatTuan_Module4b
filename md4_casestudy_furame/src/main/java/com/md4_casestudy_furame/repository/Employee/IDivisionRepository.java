package com.md4_casestudy_furame.repository.Employee;

import com.md4_casestudy_furame.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
