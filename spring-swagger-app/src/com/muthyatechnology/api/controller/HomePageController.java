package com.muthyatechnology.api.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomePageController {
	private static final Log LOG = LogFactory.getLog(HomePageController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		LOG.info("Start :: Home Page ");
		return "home";
	}
	

}
