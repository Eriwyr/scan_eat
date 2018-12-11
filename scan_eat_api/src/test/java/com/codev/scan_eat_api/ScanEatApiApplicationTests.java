package com.codev.scan_eat_api;

import com.codev.scan_eat_api.controller.IngredientController;
import com.codev.scan_eat_api.repository.IngredientRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)

public class ScanEatApiApplicationTests {
	@Mock
	IngredientRepository ingredientRepository;

	@InjectMocks
	IngredientController ingredientController = new IngredientController();

	MockMvc mockMvc;

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
	}

	@Test
	public void testInsertIgredient() throws Exception {
		//Ingredient ingredient = new Ingredient();
		//ingredientRepository.save(ingredient);

		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().string(Matchers.containsString("Hello World")));

		//verify(studentService, times(1)).insertStudent(student);


	}

	@Test
	public void contextLoads() {
	}

}



