package orion.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import orion.logic.RatingService;


@Controller
public class RatingController
{
	@Autowired
	RatingService ratingService;
	
	@RequestMapping(value="rating.html",method = RequestMethod.POST)
	public String rating(@RequestParam("rate") String rate,Model model)
	{
		String result=ratingService.rating(rate);
		model.addAttribute("result",result);
		return "rated";
	}
	
	
}
