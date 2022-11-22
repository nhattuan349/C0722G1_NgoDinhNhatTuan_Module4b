package com.email.service;

import com.email.model.Email;

import java.util.List;

public interface IEmailService {

    List<String> language();

    List<Integer> pageSize();

    List<String> spamsFilter();

}
