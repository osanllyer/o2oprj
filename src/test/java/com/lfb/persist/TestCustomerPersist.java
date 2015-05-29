package com.lfb.persist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;

import com.lfb.web.conf.AppConfig;
import com.lfb.web.conf.WebConfig;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {
		AppConfig.class, WebConfig.class })
public class TestCustomerPersist {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private MockServletContext servletContext;

	@Autowired
	private MockHttpServletRequest request;

	@Autowired
	private MockHttpServletResponse response;

	@Autowired
	private MockHttpSession session;

	@Autowired
	private ServletWebRequest webRequest;

	@Test
	public void test() {
		System.out.println("a");
	}

}
