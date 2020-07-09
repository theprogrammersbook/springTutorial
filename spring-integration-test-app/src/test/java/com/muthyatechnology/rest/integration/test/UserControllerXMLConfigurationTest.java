package com.muthyatechnology.rest.integration.test;

/*import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;*/

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.muthyatechnology.rest.integration.controller.UserController;
import com.muthyatechnology.rest.integration.service.UserServiceImplThis;
/*
 * This is class conitains some comppilation problems, this code is usefull to xml configruation 
 */


/*@ContextConfiguration
(
  {
   "classpath:beans.xml",
   "file:src/main/webapp/WEB-INF/spring/applicationContext.xml",
   "file:src/main/webapp/WEB-INF/spring/dispatcher-data-servlet.xml",
   "file:src/main/webapp/WEB-INF/spring/dispatcher-servlet.xml"
  }
)*/
/*@ContextConfiguration(locations={"classpath:app-config.xml"})*/
/*@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })*/
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerXMLConfigurationTest {
	private MockMvc mockMvc;
	@Autowired
	WebApplicationContext wac;
	@Spy
	private UserServiceImplThis userService;

	@InjectMocks
	private UserController userController;
	
	//@Autowired
	//FCUserDao userDao; // Some Dao 

	//@Autowired
	//UserProfileDAO userProfileDao;//// Some Dao 

	//@Mock
	//SpringMongo springMongo; // some Class which is going to return MongoTemplate

	//@Mock
	//MongoTemplate mongoTemplate;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		MockitoAnnotations.initMocks(this);
		//we are creating the Mockito on the entaire application with the help of WebApplicationContext
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(wac);
		mockMvc = builder.build();
		
		// if we want to mock some of methods in springMongo, then we can do in the following way
		/*Mockito.when(springMongo.mongoTemplate(any())).thenReturn(mongoTemplate);
		Mockito.when(springMongo.mongoTemplateMaster()).thenReturn(mongoTemplate);*/
		// when we observe here we are have created 
		// userDao object because it is going to used any any API call of the any test
		// userProfileDao object because it is going to used any any API call of the any test
		// the following 2 lines of code , helps use to inject the mocks of SpringMongo to the userDao and userProfileDao  
		// if we do not reflect these then the test will take the original userDao with Springmongo and userProfileDao with SpringMongo
		/*ReflectionTestUtils.setField(userDao, "springMongo", springMongo,
				SpringMongo.class);
		ReflectionTestUtils.setField(userProfileDao, "springMongo", springMongo,
				SpringMongo.class);*/
		
	}
	
	/*@Test
	public void test_AuthSuccess() throws Exception {
		String request = "{\"UserName\":\"admin\", \"Password\":\"admin\"}";
		Mockito.when(mongoTemplate.findOne(Mockito.any(),  Mockito.eq(UserProfileBean.class), Mockito.eq(APPLiterals.USER_REGISTRATION_COLLECTION))).thenReturn(adminUser);
		BasicDBObject theBasicDBObjecgt = new BasicDBObject();
		theBasicDBObjecgt.put("ExpireDuration", 21);
		Mockito.when(mongoTemplate.findOne(Mockito.any(), Mockito.eq(BasicDBObject.class),Mockito.eq("token_validity"))).thenReturn(theBasicDBObjecgt);
		ResultActions result = mvc.perform(MockMvcRequestBuilders.post("api/this").content(request));

		result.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.header().string(APPLiterals.YCP_API_TOKEN, adminUser.getRefreshToken()));
	}
	@Test
	public void test_Auth_400007() throws Exception {
		String request = "{";
		ResultActions result = mvc.perform(MockMvcRequestBuilders.post("api/something").content(request));

		result.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.Code")
								.value(YCPHttpStatus.CANNOT_PARSE_REQUEST_BODY.getValue()))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.Message")
								.value(YCPHttpStatus.CANNOT_PARSE_REQUEST_BODY.getMessage()));
	}*/
}
