package com.md4_casestudy_furame.repository.user;


import com.md4_casestudy_furame.model.user_role.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String name);

}
