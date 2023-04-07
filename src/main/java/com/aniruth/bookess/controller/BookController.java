package com.aniruth.bookess.controller;

import com.aniruth.bookess.model.Book;
import com.aniruth.bookess.model.User;
import com.aniruth.bookess.service.BookService;
import com.aniruth.bookess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/books")
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/my-books")
    public String showMyBooks(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "my-books";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute Book book, Principal principal) {
        String username = principal.getName();
        bookService.addBook(book, username);
        return "redirect:/my-books";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "redirect:/login?registrationSuccess";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

}
