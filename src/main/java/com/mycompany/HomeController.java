package com.mycompany;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@Autowired
	private ContactService contactService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String displayHomePage(ModelMap model) {
		model.addAttribute("contact", new Contact());
		return "Home";
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	@ResponseBody
	public String displayHomePage(Contact contact) {
		contactService.sendContactDetails(contact);
		return contact.toString();
	}

}
