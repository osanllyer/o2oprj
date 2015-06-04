package com.lfb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lfb.service.search.SearchService;


@Controller
public class SearchController {

	@Autowired
	SearchService _searchSrv;
	
}
