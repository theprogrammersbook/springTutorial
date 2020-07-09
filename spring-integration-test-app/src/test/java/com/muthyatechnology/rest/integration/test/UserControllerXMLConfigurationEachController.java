package com.muthyatechnology.rest.integration.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * This code will work properly , when we add the required class or change the classes
 */
import com.muthyatechnology.rest.integration.utils.ResultValidation;

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
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerXMLConfigurationEachController {
	private static final String TOKEN_VALUE = "fmmfJf9As40=YWRtaW4xNTM2MDM5MzY2NDk1";

	private MockMvc mockMvc;

	@Spy
	@Autowired
	private SystemServiceImpl systemService;

	@Mock
	private WebAPIServiceImpl webAPIService;

	@InjectMocks
	private SystemController systemController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(systemController).addFilters(new CORSFilter()).build();

	}

	@Test
	public void test_MQConnectionError() throws Exception {
		JSONArray array = new JSONArray();
		when(webAPIService.checkAuthorization(TOKEN_VALUE)).thenReturn(true);
		try {
			mockMvc.perform(post("/api/v2/events").contentType(MediaType.APPLICATION_JSON)
					.header("TOKEN", TOKEN_VALUE).content(asJsonString(array)))
			.andDo(MockMvcResultHandlers.print()).andExpect(status().isInternalServerError());
		} catch (Exception ex) {
			MCPAPIException MCPapiException = (MCPAPIException) ExceptionUtils.getRootCause(ex);
			JSONObject response = ResultValidation.getJSONObject(MCPapiException.getMessage());
			System.out.println(response);
			Object[] expected = new Object[2];
			expected[0] = "500002";
			expected[1] = "MQ connection error.";
			ResultValidation.checkErrorCodeResponse(MCPapiException.getMessage(), expected);

		}
	}

	@Test
	public void test_EventsSuccess() throws Exception {
		JSONArray array = new JSONArray();
		when(webAPIService.checkAuthorization(TOKEN_VALUE)).thenReturn(true);
		YasakawaMsgProducer messageProducer = mock(YasakawaMsgProducer.class);
		ReflectionTestUtils.setField(systemService, "messageProducer", messageProducer);
		doNothing().when(messageProducer).checkMQStatus();

		JSONArray eventArray = new JSONArray();
		JSONObject object = new JSONObject();
		JSONObject eventsData = new JSONObject();
		eventsData.put("Source", "NagarajuNagaraju");
		eventsData.put("Name", "GajulaGajulaGajula");
		object.put("Event", eventsData);
		eventArray.add(object);
		try {
			mockMvc.perform(post("/api/v2/events").contentType(MediaType.APPLICATION_JSON)
					.header("MCP-API-TOKEN", TOKEN_VALUE).content(asJsonString(eventArray)))
					.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
