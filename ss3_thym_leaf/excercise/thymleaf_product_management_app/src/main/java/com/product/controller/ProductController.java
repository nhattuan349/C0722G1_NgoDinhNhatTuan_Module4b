package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model,
                            RedirectAttributes redirectAttributes ){
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        redirectAttributes.addFlashAttribute("message","");
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product,
                       RedirectAttributes redirectAttributes){
        product.setId((int)(Math.random()*10000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","Thêm thành công");
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.finfById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product,
                         RedirectAttributes redirectAttributes){
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Sửa thành công");
        return "redirect:/product";
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id, Model model){
        model.addAttribute("product",productService.finfById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product,
                         RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "xóa thành công");
        return "redirect:/product";
    }

    @GetMapping("{id}/view")
    public String showView(@PathVariable int id, Model model){
        model.addAttribute("product", productService.finfById(id));
        return "view";
    }

    @GetMapping("/search")
    public String searchName(@RequestParam String name, Model model){
        model.addAttribute("products",productService.findByName(name));
        return "list";
    }


}
