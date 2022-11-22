package com.email.service.impl;

import com.email.model.Email;
import com.email.repository.IEmailRepository;
import com.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private IEmailRepository emailRepository;


    @Override
    public List<String> language() {
        return emailRepository.language();
    }

    @Override
    public List<Integer> pageSize() {
        return emailRepository.pageSize();
    }

    @Override
    public List<String> spamsFilter() {
        return emailRepository.spamsFilter();
    }
}
