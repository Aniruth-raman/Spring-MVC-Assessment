package com.spring.mvc.controller;

import com.spring.mvc.entity.Books;
import com.spring.mvc.entity.Users;
import com.spring.mvc.service.BooksService;
import com.spring.mvc.service.UserBookService;
import com.spring.mvc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {
    @Autowired
    BooksService bookService;

    @Autowired
    UsersService usersService;

    @Autowired
    UserBookService userBookService;
    @RequestMapping(value = "/")
    public String root(Map<String, List<Books>> map) {
        List<Books> books = this.bookService.getAllBooks();
        System.out.println(books);
        map.put("books", books);
        return "dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(HttpSession session, Map<String, List<Books>> map) {
        String email = (String) session.getAttribute("email");
        if (email == null) return "redirect:login";
        List<Books> books = this.bookService.getAllBooks();
        System.out.println(books);
        map.put("books", books);
        return "dashboard";
    }


    @GetMapping("/add-to-liked/{bookId}")
    public String addToLiked(@PathVariable("bookId") int bookId, HttpSession session) {
        Users user = usersService.findByUsername(session.getAttribute("username").toString());
        Books book = bookService.findById(bookId);
        userBookService.addToFavorites(user, book);
        return "redirect:/dashboard";
    }

    @GetMapping("/read-later/{bookId}")
    public String readLater(@PathVariable("bookId") int bookId, HttpSession session) {
        Users user = usersService.findByUsername(session.getAttribute("username").toString());
        Books book = bookService.findById(bookId);
        userBookService.addToReadLater(user, book);
        return "redirect:/dashboard";
    }

    @GetMapping("/remove-from-liked/{bookId}")
    public String removeFromLiked(@PathVariable("bookId") int bookId, HttpSession session) {
        Users user = usersService.findByUsername(session.getAttribute("username").toString());
        Books book = bookService.findById(bookId);
        userBookService.removeFromFavorites(user, book);
        return "redirect:/dashboard";
    }

    @GetMapping("/remove-from-read-later/{bookId}")
    public String removeFromReadLater(@PathVariable("bookId") int bookId, HttpSession session) {
        Users user = usersService.findByUsername(session.getAttribute("username").toString());
        Books book = bookService.findById(bookId);
        userBookService.removeFromReadLater(user, book);
        return "redirect:/dashboard";
    }
    @GetMapping("/liked")
    public String getLiked(Map<String, List<Books>> map,HttpSession session){
        Users user = usersService.findByUsername(session.getAttribute("username").toString());
        map.put("books",userBookService.getFavorites(user));
        System.out.println("Liked Books:"+userBookService.getFavorites(user));
        return "liked-books";
    }
    @GetMapping("/read-later")
    public String getReadLater(Map<String, List<Books>> map,HttpSession session){
        Users user = usersService.findByUsername(session.getAttribute("username").toString());
        map.put("books",userBookService.getReadLater(user));
        System.out.println("Read Later Books:"+userBookService.getReadLater(user));
        return "read-later-books";
    }

}
