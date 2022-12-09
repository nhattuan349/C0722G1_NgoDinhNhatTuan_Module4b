package com.md4_casestudy_furame.repository.Employee;

import com.md4_casestudy_furame.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select e.* " +
            "from `employee` e " +
            "join `division` d on e.division_id = d.id " +
            "join `education_degree` ed on e.education_degree_id = ed.id " +
            "join `position` p on  e.position_id = p.id " +
            "where e.name like concat('%', :name,'%') " +
                  "and d.name like concat('%', :division,'%') " +
                  "and ed.name like concat('%', :educationDegree,'%') " +
                  "and p.name like concat('%', :position,'%') " +
            "and e.status=0 " +
            "order by e.id desc " , nativeQuery = true)
    Page<Employee> findByName(Pageable pageable,
                              @Param("name") String name,
                              @Param("division") String division,
                              @Param("educationDegree") String educationDegree,
                              @Param("position") String position);



}
