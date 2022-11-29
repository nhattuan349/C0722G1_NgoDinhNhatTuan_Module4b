package com.ss8_validate_registration_form.service;

import com.ss8_validate_registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IUserService extends IGeneralService<User> {

    Page<User> findByNameRegister(Pageable pageable, String firstName, String lastName);

}
