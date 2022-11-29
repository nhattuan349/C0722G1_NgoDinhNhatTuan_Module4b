package com.ss8_validate_registration_form.service.impl;

import com.ss8_validate_registration_form.model.User;
import com.ss8_validate_registration_form.repository.IUserRepository;
import com.ss8_validate_registration_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findByNameRegister(Pageable pageable, String firstName, String lastName) {
        return userRepository.findByNameRegister(pageable, firstName, lastName);
    }
}
