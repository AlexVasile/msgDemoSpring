package ro.msgdemo.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ro.msgdemo.app.service.MsgService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("msgService")
	MsgService msgService;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("msgs", msgService.getAllMessages());
		return "home";
	}
	
	@RequestMapping(value = "/postMessageForm", method = RequestMethod.GET)
	public String postForm(Model model) {
		return "form";
	}
	
	@RequestMapping(value = "/postMsg", method = RequestMethod.POST)
	public String postMsg(Model model, 
			@RequestParam(value="content") String msg,
			@RequestParam(value="username", required=false) String username) {
		
		if (msg != null && !msg.equals("")) {
			msgService.saveMessage(msg, username);
		}
		
		return "redirect:/";
	}
}
