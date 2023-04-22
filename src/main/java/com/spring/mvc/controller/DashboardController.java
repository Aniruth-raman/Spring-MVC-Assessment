package com.spring.mvc.controller;

import com.spring.mvc.entity.Books;
import com.spring.mvc.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {
    @Autowired
    BooksService bookService;

    @GetMapping("/dashboard")
    public String dashboardPage(HttpSession session, Map<String, List<Books>> map) {
        String email = (String) session.getAttribute("email");
        if (email == null) return "redirect:login";
        List<Books> books = this.bookService.getAllBooks();
        map.put("books", books);
        return "dashboard";
    }
}
