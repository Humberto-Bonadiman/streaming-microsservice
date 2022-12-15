package com.java.seriesservice.series;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
class SeriesFindAllApplicationTest {

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
	@Order(2)
	@DisplayName("2 - Must show all series successfully")
	void showAllSeriesSuccessfully() throws Exception {
		Series firstSerie = SeriesCreate.create();
		seriesRepository.save(firstSerie);
		Series secondSerie = SeriesCreate.createSecond();
		seriesRepository.save(secondSerie);
		mockMvc.perform(get("/series-service"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$[0].title").value(firstSerie.getTitle()))
	        .andExpect(jsonPath("$[0].synopsis").value(firstSerie.getSynopsis()))
	        .andExpect(jsonPath("$[0].seasons").value(firstSerie.getSeasons()))
	        .andExpect(jsonPath("$[0].releaseYear").value(firstSerie.getReleaseYear()))
	        .andExpect(jsonPath("$[0].episodesPerSeason[0]").value(
	            firstSerie.getEpisodesPerSeason().get(0)))
	        .andExpect(jsonPath("$[0].image").value(firstSerie.getImage()))
	        .andExpect(jsonPath("$[0].categories[0]").value(firstSerie.getCategories().get(0)))
	        .andExpect(jsonPath("$[1].title").value(secondSerie.getTitle()))
	        .andExpect(jsonPath("$[1].synopsis").value(secondSerie.getSynopsis()))
	        .andExpect(jsonPath("$[1].seasons").value(secondSerie.getSeasons()))
	        .andExpect(jsonPath("$[1].releaseYear").value(secondSerie.getReleaseYear()))
	        .andExpect(jsonPath("$[1].episodesPerSeason[0]").value(
	            secondSerie.getEpisodesPerSeason().get(0)))
	        .andExpect(jsonPath("$[1].image").value(secondSerie.getImage()))
	        .andExpect(jsonPath("$[1].categories[0]").value(secondSerie.getCategories().get(0)));
	}

}
