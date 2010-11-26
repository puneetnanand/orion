package orion.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import orion.core.models.util.UsersManagementUtil;
import orion.service.UserService;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login")
	public String showForm(Map model) {
		return "loginform";
	}

	@RequestMapping(value = "/welcome")
	public String welcome(@RequestParam("username") String username, Model model) {
		model.addAttribute("username", username);
		return "welcome";
	}

	@RequestMapping(value = "/loginform", method = RequestMethod.POST)
	public String processForm(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model,
			HttpSession session) {
		boolean result = userService.checkLogin(username, password);

		if (!result)
			return "loginform";
		else {
			UsersManagementUtil.registerUserOnline(username);
			model.addAttribute("username", username);
			session.setAttribute("user", username);
			return "welcome";
		}

	}

}
