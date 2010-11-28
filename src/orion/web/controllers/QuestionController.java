package orion.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import orion.dao.QuestionDao;
import orion.dao.impl.QuestionDaoImpl;

@Controller
public class QuestionController {

	@RequestMapping(value = "/postquestion")
	public String getQuestionForm(@RequestParam("username") String username,
			Model model) {
		model.addAttribute("username", username);
		return "postquestion";
	}

	@RequestMapping(value = "/postquestion", method = RequestMethod.POST)
	public String getQuestion(@RequestParam("question") String question,
			@RequestParam("username") String username, Model model, HttpServletRequest request) {
		System.out.println("printing request "+request + "\n");
		if (question.isEmpty()) {
			model.addAttribute("result", "question field is required");
			return "postquestion";
		} else {
			QuestionDao questionDao = new QuestionDaoImpl();
			boolean status = questionDao.createQuestion(username, question);
			if (status) {
				model.addAttribute("result",
						"Question is forwarded to appropriate user");
				model.addAttribute(question);
				return "view-question";
			}
			return "postquestion";
		}

	}

}
