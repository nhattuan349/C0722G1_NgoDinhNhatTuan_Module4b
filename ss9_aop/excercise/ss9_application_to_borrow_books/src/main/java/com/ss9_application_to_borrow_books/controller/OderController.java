package com.ss9_application_to_borrow_books.controller;

import com.ss9_application_to_borrow_books.model.Book;
import com.ss9_application_to_borrow_books.model.Oder;
import com.ss9_application_to_borrow_books.service.IBookService;
import com.ss9_application_to_borrow_books.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

@Controller
@RequestMapping("/oder")
public class OderController {


    @Autowired
    private IBookService bookService;

    @Autowired
    private IOderService oderService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable) {

        ModelAndView modelAndView = new ModelAndView("views/book/list");
        modelAndView.addObject("books", bookService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/{id}/oder")
    public String saveOder(@PathVariable int id, RedirectAttributes redirect) throws Exception {

        Book book = bookService.findByIdBook(id);

        if (book.getCount() == 0) {
            throw new Exception();
        }
        book.setCount(book.getCount() - 1);


        Oder oder = new Oder();
        long code = (long) (Math.random() * (99999 - 10000) + 10000);
        oder.setCode(code);

        //Lấy ngày hiện tại oder
        long millis = System.currentTimeMillis();
        oder.setDate(new java.sql.Date(millis));
        oderService.save(oder);


        List<Oder> oders = book.getList();
        oders.add(oder);
        book.setList(oders);
        bookService.save(book);

        redirect.addFlashAttribute("mess", "Oder thành công mã của bạn :" + oder.getCode());

        return "redirect:/oder";
    }

    @PostMapping("resend")
    public String savePay(@RequestParam(value = "pay") long code) {
        Book book = bookService.findByCode(code);
        Oder oder = oderService.findByCode(code);
        if (book == null) {
            System.out.println("lỗi");
        } else {
            book.setCount(book.getCount() + 1);
            bookService.save(book);
            oder.setCode(0);
            oderService.save(oder);
        }
        return "redirect:/oder";
    }

    @ExceptionHandler(Exception.class)
    public String handlerError(Exception e){
        return "views/book/error";
    }


}
