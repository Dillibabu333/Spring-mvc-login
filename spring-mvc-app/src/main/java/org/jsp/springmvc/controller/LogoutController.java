package org.jsp.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, ModelAndView view) {
		session.invalidate();
		view.addObject("msg", "You are Logged out..!");
		view.setViewName("login.jsp");
		return view;
		
	}
}
