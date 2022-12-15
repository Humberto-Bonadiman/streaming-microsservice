package com.java.seriesservice.series;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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
class SeriesUpdateApplicationTest {

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
	@Order(4)
	@DisplayName("4 - Must update a serie successfully")
	public void updateMovieSuccessfully() throws Exception {
		Series serie = SeriesCreate.create();
		seriesRepository.save(serie);
		Series updatedSerie = SeriesCreate.updateSerie();
		seriesRepository.save(updatedSerie);
	    mockMvc.perform(patch("/series-service/" + serie.getId())
	        .contentType(MediaType.APPLICATION_JSON)
	        .content(new ObjectMapper().writeValueAsString(updatedSerie)))
	        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());
	}

}
