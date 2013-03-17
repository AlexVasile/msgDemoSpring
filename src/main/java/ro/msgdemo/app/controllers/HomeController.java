package ro.msgdemo.app.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	@Qualifier("msgService")
	MsgService msgService;
	
	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
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
		
		return "redirect:home";
	}
}
