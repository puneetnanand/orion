package orion.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import orion.service.PostQuestionService;



@Controller
public class PostQuestionController
{
	@Autowired
	PostQuestionService postService;
	
	@RequestMapping(value="/postquestion")
	public String getQuestionForm(@RequestParam("username")String username,Model model)
	{
		model.addAttribute("username",username);
		return "postquestion";
	}
	
	@RequestMapping(value="/postquestion",method=RequestMethod.POST)
	public @ResponseBody String getQuestion(@RequestParam("question")String question,@RequestParam("username")String username,
			Model model)
	{
		String result=null;
		if(question.isEmpty())
			result= "question field is required";
		else
		{
			String value=postService.postQuestion(username, question);
			if(value.equalsIgnoreCase("done"))
				result="Question is forwarded to appropriate user";
		}
		return result;
	}
	
}
