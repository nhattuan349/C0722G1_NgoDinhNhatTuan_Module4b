package com.ss8_validate_registration_form.repository;

import com.ss8_validate_registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select u.* " +
            "from `user` u " +
            "where first_name like concat('%', :firstName,'%') and last_name like concat('%', :lastName,'%') "
            ,nativeQuery = true)
    Page<User> findByNameRegister(Pageable pageable,
                                  @Param("firstName") String firstName,
                                  @Param("lastName") String lastName);
}
