package orion.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyProfileController
{

	@RequestMapping(value="/profile")
	public String getProfile(@RequestParam("username")String username,Model model,HttpServletRequest request)
	{
		
		return "profile";
	}
}
