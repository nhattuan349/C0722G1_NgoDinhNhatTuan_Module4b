package com.ss9_application_to_borrow_books.service;

import com.ss9_application_to_borrow_books.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService extends IGeneralService<Book> {

    Book findByIdBook(Integer id);

    Book findByCode(long code);

    Page<Book> findAll(Pageable pageable);

}
