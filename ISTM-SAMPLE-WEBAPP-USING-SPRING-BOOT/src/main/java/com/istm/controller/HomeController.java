package com.istm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.istm.dao.UserRepository;
import com.istm.entities.User;
import com.istm.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(path="/")
	public String homPage() {
		
		
		return "home";
	}
	
	
	@RequestMapping(path="/signup")
	public String signUpPage(Model model) {
		
		
		model.addAttribute("user",new User());
		return "sign-up";
		}
	
	
	
	 @RequestMapping(value = "/do_register", method = RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user,
	                               BindingResult result,
	                               @RequestParam(value = "aggrement", defaultValue = "false") boolean aggrement,
	                               Model model,
	                               HttpSession session) {
	        try {
	            if (!aggrement) {
	                session.setAttribute("message", new Message("Please accept terms and conditions", "alert-danger"));
	                model.addAttribute("user", user);
	                return "sign-up";
	            }

	            if (result.hasErrors()) {
	                model.addAttribute("user", user);
	                return "sign-up";
	            }

	            // Save user
	            user.setRole("USER");
	            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	            userRepository.save(user);
	            session.setAttribute("message", new Message("Successfully Registered", "alert-success"));
	            model.addAttribute("user", new User());
	            return "sign-up";
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.setAttribute("message", new Message("Something went wrong Please All Fields Are Required " , "alert-danger"));
	            model.addAttribute("user", user);
	            return "sign-up";
	        }
	    }
	 
	 
	 
	 
	 
	 @RequestMapping("/signin")
	 public String customLogin(Model model) {
		 
		 model.addAttribute("title","Login Page");
		 return "login";
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	}








