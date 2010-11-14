package orion.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import orion.logic.LoginService;




import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginservice;
	
	@RequestMapping(value="/login")
	public String showForm(Map model) {
		return "loginform";
	}
	
	@RequestMapping(value="/welcome")
	public String welcome(@RequestParam("username")String username,Model model)
	{
		model.addAttribute("username",username);
		return "welcome";
	}

	@RequestMapping(value="/loginform",method = RequestMethod.POST)
	public String processForm(@RequestParam("username")String username,@RequestParam("password")String password,
			Model model,HttpSession session) {
		ArrayList dbcheck=loginservice.logincheck(username, password);
	
		if(dbcheck.get(0)==null)
			return "loginform";
		else
		{
			if(dbcheck.get(1)!=null)
				System.out.println("there are results");
			model.addAttribute("onlineUser",dbcheck.get(1));
			model.addAttribute("username",username);
			session.setAttribute("user", username);
			return "welcome";
		}
		
	}

}
