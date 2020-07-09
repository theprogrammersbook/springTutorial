package com.muthyatechnology.xmlconfigtdd.test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.muthyatechnology.xmlconfigtdd.bean.User;
import com.muthyatechnology.xmlconfigtdd.controller.api.MockUserController;
import com.muthyatechnology.xmlconfigtdd.service.MockUserService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/servlet-context.xml","/root-context.xml"})

public class MockUserControllerUnitTest {
	 private MockMvc mockMvc;

	    @Spy
	    @Inject
	    @Named("mockUserService")
	    private MockUserService mockUserService;

	    @InjectMocks
	    private MockUserController mockUserController;

	    @Before
	    public void init(){
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders
	                .standaloneSetup(mockUserController)
	               // .addFilters(new CORSFilter())
	                .build();
	    }

	    // =========================================== Get All Users ==========================================

	    @Test
	    public void test_get_all_success() throws Exception {
	        List<User> users = Arrays.asList(
	                new User(1, "Daenerys"),
	                new User(2, "John Snow"));
	        /*when(searchService.controllerAnalysisResult(new HashMap<>(), searchRequest))
			.thenThrow(new YCPAPIException(YCPHttpStatus.CANNOT_PARSE_CONFIG_XML));*/
	        when(mockUserService.getAll()).thenReturn(users);

	        mockMvc.perform(get("/users"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	                .andExpect(jsonPath("$", hasSize(2)))
	                .andExpect(jsonPath("$[0].id", is(1)))
	                .andExpect(jsonPath("$[0].username", is("Daenerys")))
	                .andExpect(jsonPath("$[1].id", is(2)))
	                .andExpect(jsonPath("$[1].username", is("John Snow")));

	        verify(mockUserService, times(1)).getAll();
	        verifyNoMoreInteractions(mockUserService);
	    }

	    // =========================================== Get User By ID =========================================

	   // @Test
	    public void test_get_by_id_success() throws Exception {
	        User user = new User(1, "Daenerys Targaryen");

	        when(mockUserService.findById(1)).thenReturn(user);

	        mockMvc.perform(get("/users/{id}", 1))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	                .andExpect(jsonPath("$.id", is(1)))
	                .andExpect(jsonPath("$.username", is("Daenerys Targaryen")));

	        verify(mockUserService, times(1)).findById(1);
	        verifyNoMoreInteractions(mockUserService);
	    }

	   // @Test
	    public void test_get_by_id_fail_404_not_found() throws Exception {
	        when(mockUserService.findById(1)).thenReturn(null);

	        mockMvc.perform(get("/users/{id}", 1))
	                .andExpect(status().isNotFound());

	        verify(mockUserService, times(1)).findById(1);
	        verifyNoMoreInteractions(mockUserService);
	    }

	    // =========================================== Create New User ========================================

	   // @Test
	    public void test_create_user_success() throws Exception {
	        User user = new User("Arya Stark");

	        when(mockUserService.exists(user)).thenReturn(false);
	        doNothing().when(mockUserService).create(user);

	        mockMvc.perform(
	                post("/users")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(asJsonString(user)))
	                .andExpect(status().isCreated())
	                .andExpect(header().string("location", containsString("/users/0")));

	        verify(mockUserService, times(1)).exists(user);
	        verify(mockUserService, times(1)).create(user);
	        verifyNoMoreInteractions(mockUserService);
	    }

	    //@Test
	    public void test_create_user_fail_404_not_found() throws Exception {
	        User user = new User("username exists");

	        when(mockUserService.exists(user)).thenReturn(true);

	        mockMvc.perform(
	                post("/users")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(asJsonString(user)))
	                .andExpect(status().isConflict());

	        verify(mockUserService, times(1)).exists(user);
	        verifyNoMoreInteractions(mockUserService);
	    }

	    // =========================================== Update Existing User ===================================

	    //@Test
	    public void test_update_user_success() throws Exception {
	        User user = new User(1, "Arya Stark");

	        when(mockUserService.findById(user.getId())).thenReturn(user);
	        doNothing().when(mockUserService).update(user);

	        mockMvc.perform(
	                put("/users/{id}", user.getId())
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(asJsonString(user)))
	                .andExpect(status().isOk());

	        verify(mockUserService, times(1)).findById(user.getId());
	        verify(mockUserService, times(1)).update(user);
	        verifyNoMoreInteractions(mockUserService);
	    }

	   // @Test
	    public void test_update_user_fail_404_not_found() throws Exception {
	        User user = new User(999, "user not found");

	        when(mockUserService.findById(user.getId())).thenReturn(null);

	        mockMvc.perform(
	                put("/users/{id}", user.getId())
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(asJsonString(user)))
	                .andExpect(status().isNotFound());

	        verify(mockUserService, times(1)).findById(user.getId());
	        verifyNoMoreInteractions(mockUserService);
	    }

	    // =========================================== Delete User ============================================

	    //@Test
	    public void test_delete_user_success() throws Exception {
	        User user = new User(1, "Arya Stark");

	        when(mockUserService.findById(user.getId())).thenReturn(user);
	        doNothing().when(mockUserService).delete(user.getId());

	        mockMvc.perform(
	                delete("/users/{id}", user.getId()))
	                .andExpect(status().isOk());

	        verify(mockUserService, times(1)).findById(user.getId());
	        verify(mockUserService, times(1)).delete(user.getId());
	        verifyNoMoreInteractions(mockUserService);
	    }

	    //@Test
	    public void test_delete_user_fail_404_not_found() throws Exception {
	        User user = new User(999, "user not found");

	        when(mockUserService.findById(user.getId())).thenReturn(null);

	        mockMvc.perform(
	                delete("/users/{id}", user.getId()))
	                .andExpect(status().isNotFound());

	        verify(mockUserService, times(1)).findById(user.getId());
	        verifyNoMoreInteractions(mockUserService);
	    }

	    // =========================================== CORS Headers ===========================================

	   // @Test
	    public void test_cors_headers() throws Exception {
	        mockMvc.perform(get("/users"))
	                .andExpect(header().string("Access-Control-Allow-Origin", "*"))
	                .andExpect(header().string("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE"))
	                .andExpect(header().string("Access-Control-Allow-Headers", "*"))
	                .andExpect(header().string("Access-Control-Max-Age", "3600"));
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
