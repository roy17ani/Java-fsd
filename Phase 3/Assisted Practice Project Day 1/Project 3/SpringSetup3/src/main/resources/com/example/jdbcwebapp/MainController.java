package com.example.jdbcwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EProductDAO productDAO;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/listProducts")
    public String listProducts(Model model) {
        List<EProduct> products = productDAO.getAllProducts();
        model.addAttribute("products", products);
        return "listProducts";
    }
}
