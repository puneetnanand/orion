package orion.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController
{
	@RequestMapping(value="/chat")
	public @ResponseBody String startchat(@RequestParam("action")String action,Model model,HttpSession session)
	{ 
		System.out.println(action);
		model.addAttribute("username",session.getAttribute("setVariable"));
		return "jsonView";
	}
	@RequestMapping(value="/chat",method=RequestMethod.POST)
	public @ResponseBody String chat(@RequestParam("to")String to,@RequestParam("message")String message,
			@RequestParam("action")String action,Model model,HttpSession session)
	{

		System.out.println(action);
		System.out.println(to);
		System.out.println(message);
		model.addAttribute("username",session.getAttribute("setVariable"));
		return "sojoView";
	}

	private void startChatSession() {
		// TODO Auto-generated method stub
		
	}

	private void closeChat() {
		// TODO Auto-generated method stub
		
	}

	private void sendChat() {
		// TODO Auto-generated method stub
		
	}

	private void chatHeartbeat() {
		// TODO Auto-generated method stub
		
	}

}
