package com.md4_casestudy_furame.repository.Employee;

import com.md4_casestudy_furame.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
