package com.ss9_application_to_borrow_books.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class logger {
    @AfterThrowing(value = "execution(* com.ss9_application_to_borrow_books.controller.BookController.oder(..))")
    public void checkEx(){
        System.out.println("----------------");
        System.out.println("ERROR");
    }

    @After(value = "execution(* com.ss9_application_to_borrow_books.controller.BookController.oder(..))")
    public void checkOk(){
        System.out.println("----------------");
        System.out.println("OK");
    }
}
