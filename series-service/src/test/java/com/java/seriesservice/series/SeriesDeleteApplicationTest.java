package com.java.seriesservice.series;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.java.seriesservice.model.Series;
import com.java.seriesservice.repository.SeriesRepository;
import com.java.seriesservice.utils.SeriesCreate;

@AutoConfigureMockMvc
@SpringBootTest
class SeriesDeleteApplicationTest {

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
	@Order(5)
	@DisplayName("5 - Must delete a serie successfully")
	public void deleteMovieSuccessfully() throws Exception {
		Series serie = SeriesCreate.create();
		seriesRepository.save(serie);
	    mockMvc.perform(delete("/series-service/" + serie.getId()))
	    	.andExpect(status().isNoContent());
	}

}
