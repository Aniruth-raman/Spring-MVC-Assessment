package com.spring.mvc.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.mvc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.service.UsersService;

@Controller
public class LoginController {

	@Autowired
	private UsersService usersService;

	/**
	 * GET /login -> appends data on the url
	 * it can send only 256 characters
	 * 
	 * POST /login -> sends the data as a payload in the body of the request
	 * it is secured and no limitations on the amount of data you can send
	 * 
	 * @return
	 */
	// @RequestMapping(path = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String loginPage(HttpServletRequest request,
			Map<String, List<String>> map,
			Map<String, String> errormap,
			@RequestParam(required = false) String error) {
		// GET
		if (error != null)
			errormap.put("error", error);
		System.out.println("login request " + request.getMethod());
		List<String> roles = Arrays.asList("ADMIN", "USER", "DEV");
		map.put("roles", roles);
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session,
			HttpServletResponse resp,
			HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		System.out.println(cookies.length);
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName());
			if (cookie.getName().equals("email"))
				cookie.setMaxAge(0);
			else if (cookie.getName().equals("JSESSIONID"))
				cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		session.removeAttribute("email");
		session.invalidate();
		return "redirect:index.jsp";
	}

	// @RequestMapping(path = "/login", method = RequestMethod.POST)
	@PostMapping("/login")
	public String loginPostPage(Users user, HttpServletRequest request,
								HttpSession session, HttpServletResponse resp) {
		// POST
		System.out.println("login request " + request.getMethod());
		System.out.println("email " + user.getEmail());
		System.out.println("pwd " + user.getPassword());
		try {
			if (this.usersService.validateUser(user)) {
				System.out.println("Inside the validate");
				Cookie cookie = new Cookie("email", user.getEmail());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("username", user.getUsername());
				resp.addCookie(cookie);
				return "redirect:dashboard";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			return "redirect:login?error=Invalid credentials";
		}
		// failure => redirect (GET)
		return "redirect:login?error=Invalid credentials";
	}
}
