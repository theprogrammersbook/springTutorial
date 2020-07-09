/**
 * 
 */
package com.muthyatechnology.api.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nagaraju G
 *
 */
@RestController
public class TestController {
	private static final Log LOG = LogFactory.getLog(TestController.class);

	@RequestMapping(value = "/check", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloWorldWithPath() {
		LOG.info("Checking the Sys out from Test Controller");
		return new ResponseEntity<String>("Checking", HttpStatus.OK);
	}

}
