package com.lfb.web.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wordnik.swagger.annotations.Api;

@Api(value="Compare", description="compare controller")
@Controller
@RequestMapping(value="/compare")
public class SearchCompareController {

	@Value("${solraddr}")
	private String solrAddr;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String init(ModelMap model){
		System.out.println(solrAddr);
		return solrAddr;
	}
	
}

