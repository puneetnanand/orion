package orion.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import orion.core.models.Registration;
import orion.logic.ProfileService;




@Controller
public class RegistrationController {
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	private RegistrationValidation registrationValidation;
	

	public void setRegistrationValidation(
			RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}

	// Display the form on the get request
	@RequestMapping(value="/registrationform",method = RequestMethod.GET)
	public String showRegistration(Map model) {
		return "registrationform";
	}

	// Process the form.
	@RequestMapping(value="/registration",method = RequestMethod.POST)
	public String processRegistration(@RequestParam("username")String username,@RequestParam("password")String password,
			@RequestParam("firstname")String firstname,@RequestParam("lastname")String lastname,@RequestParam("email")String email,
			@RequestParam("skills")String skills,@RequestParam("exp")String exp,Model model,HttpServletRequest request) throws Exception{

		//HashMap<String,String> errors=new HashMap<String, String>();
		if(!username.isEmpty() && !password.isEmpty() && !firstname.isEmpty() && !lastname.isEmpty() && !skills.isEmpty() && !exp.isEmpty())
		{
			Registration reg=new Registration();
			reg.setUserName(username);
			reg.setPassword(password);
			reg.setFirstname(firstname);
			reg.setLastname(lastname);
			reg.setEmail(email);
			reg.setSkills(skills);
			reg.setExperience(exp);
			
			String data=profileService.insertProfile(reg);
			model.addAttribute("result", data);
			return "registrationsuccess";
		}
		else
		{
			model.addAttribute("errors","All fields are compulsory to enter");
			return "error";
		}

	}
}
