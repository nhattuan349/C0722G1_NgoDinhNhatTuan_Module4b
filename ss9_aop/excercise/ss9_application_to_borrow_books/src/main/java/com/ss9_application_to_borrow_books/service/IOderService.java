package com.ss9_application_to_borrow_books.service;

import com.ss9_application_to_borrow_books.model.Oder;

public interface IOderService extends IGeneralService<Oder> {

    Oder findByCode(long code);

}
