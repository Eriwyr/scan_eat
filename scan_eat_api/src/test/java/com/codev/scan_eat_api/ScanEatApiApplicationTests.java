package com.codev.scan_eat_api;

import com.codev.scan_eat_api.controller.publiccontrollers.PublicIngredientController;
import com.codev.scan_eat_api.repository.IngredientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.GeneratedValue;



@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)

public class ScanEatApiApplicationTests {
	@Autowired
	private WebApplicationContext wac;

    /*@Autowired
    private FilterChainProxy springSecurityFilterChain;*/

	@Mock
	private IngredientRepository ingredientRepository;

	@InjectMocks
	private PublicIngredientController publicIngredientController = new PublicIngredientController();

	private MockMvc mockMvc;

	@GeneratedValue(generator = "uuid")
	private String id;

	@Before
	public void setup(){
		//mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
		//this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(springSecurityFilterChain).build();
	}

	@Test
	public void testGetAllIngredients() throws Exception {

		/*this.mockMvc.perform(get("/"))
				.andExpect(status().isOk()
				.andExpect(content().string(Matchers.containsString("Hello World")));
		//verify(studentService, times(1)).insertStudent(student);*/


	}

	@Test
	public void contextLoads() {
	}

}



