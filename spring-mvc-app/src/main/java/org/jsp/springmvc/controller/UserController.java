package org.jsp.springmvc.controller;

import javax.swing.text.View;

import org.jsp.springmvc.dao.UserDao;
import org.jsp.springmvc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names = {"u"})
public class UserController {

	@Autowired
	private UserDao dao;
	
	@RequestMapping("/register")
	public ModelAndView register(@ModelAttribute User user, ModelAndView view) {
		user=dao.saveUser(user);
		view.addObject("u", user);
		view.addObject("msg", "Welcome to Home page Mr. "+user.getName());
		view.setViewName("home.jsp");
		return view;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam long phone,@RequestParam String password, ModelAndView view,@ModelAttribute User user) {
		user=dao.verifyUser(phone,password);
		if(user!=null) {
			view.addObject("u", user);
			view.addObject("msg", "Welcome to Home page Mr. "+user.getName());
			view.setViewName("home.jsp");
			return view;
		}
		else {
			view.addObject("msg", "Invalid Phone number or Password..!");
			view.setViewName("login.jsp");
			return view;
		}	 
	}
	
	@RequestMapping("/update")
	public ModelAndView updateUser(@ModelAttribute User user, ModelAndView view)
	{
		user=dao.updateUser(user);
		view.addObject("msg", "User updated successfullyy");
		view.addObject("u", user);
		view.setViewName("viewUser.jsp");

		return view;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id, ModelAndView view) {
		boolean isdelete=dao.deleteUser(id);
		if(isdelete) {
			view.addObject("msg", "Your account is Deleted");
			view.setViewName("login.jsp");
			return view;
		}
		else {
			view.addObject("msg", "You must login to Delete");
			view.setViewName("login.jsp");
			return view;
		}
	}

	
}