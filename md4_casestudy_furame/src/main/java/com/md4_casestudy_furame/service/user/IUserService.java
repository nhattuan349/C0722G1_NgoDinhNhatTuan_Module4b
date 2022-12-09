package com.md4_casestudy_furame.service.user;

import com.md4_casestudy_furame.model.user_role.User;
import com.md4_casestudy_furame.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();

    Optional<User> findById(long id);

    void save(User user);

    void remove(long id);


}
