package com.java.seriesservice.series;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import com.java.seriesservice.model.Series;
import com.java.seriesservice.repository.SeriesRepository;
import com.java.seriesservice.utils.SeriesCreate;

@AutoConfigureMockMvc
@SpringBootTest
class SeriesFindByIdApplicationTest {


	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private SeriesRepository seriesRepository;

	@BeforeEach
	void setUp() throws Exception {
		seriesRepository.deleteAll();
	}

	@AfterEach
	void tearDown() throws Exception {
		seriesRepository.deleteAll();
	}

	@Test
	@Order(3)
	@DisplayName("3 - Must find a serie by id successfully")
	void findSerieById() throws Exception {
		Series serie = SeriesCreate.create();
		seriesRepository.save(serie);
		mockMvc.perform(get("/series-service")
		    .contentType(MediaType.APPLICATION_JSON)
		    .content(new ObjectMapper().writeValueAsString(serie)))
	        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());
	}

}
