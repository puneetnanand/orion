package orion.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import orion.core.models.util.UsersManagementUtil;
import orion.dao.UserDao;
import orion.dao.impl.UserDaoImpl;
import orion.web.helpers.SpringContextHelper;
import java.util.Map;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

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

		UserDao userDao = new UserDaoImpl();
		boolean result = userDao.checkLogin(username, password);

		if (!result)
			return "loginform";
		else {
			new UsersManagementUtil().registerUserOnline(username);
			model.addAttribute("username", username);
			session.setAttribute("user", username);
			return "welcome";
		}

	}

}
