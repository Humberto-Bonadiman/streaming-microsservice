package com.java.streamingservice.streaming;

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

import com.java.streamingservice.model.Streaming;
import com.java.streamingservice.proxy.MoviesProxy;
import com.java.streamingservice.proxy.SeriesProxy;
import com.java.streamingservice.repository.StreamingRepository;
import com.java.streamingservice.response.Movies;
import com.java.streamingservice.response.MoviesDto;
import com.java.streamingservice.response.Series;
import com.java.streamingservice.response.SeriesDto;
import com.java.streamingservice.utils.CreateStreaming;

@SpringBootTest
@AutoConfigureMockMvc
class StreamingUpdatesApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StreamingRepository streamingRepository;

	@Autowired
	private MoviesProxy moviesProxy;

	@Autowired
	private SeriesProxy seriesProxy;

	@BeforeEach
	void setUp() throws Exception {
		streamingRepository.deleteAll();
	}

	@AfterEach
	void cleanUp() {
		streamingRepository.deleteAll();
	}

  // /streaming-service/addSerie?id=82&idSerie=88	

	@Test
	@Order(5)
	@DisplayName("5 - Must update a streaming with a movie successfully")
	void updateWithMovieSuccessfully() throws Exception {
		Streaming streaming = CreateStreaming.create();
		streamingRepository.save(streaming);
		MoviesDto movie = CreateStreaming.movie();
		Movies createMovie = moviesProxy.createMovie(movie);
		Streaming updateStreaming = CreateStreaming.updateMovie(createMovie.getId());
	    mockMvc.perform(patch("/streaming-service/addMovie?id="
		    + streaming.getId()
		    + "&idMovie="
		    + createMovie.getId())
		    .contentType(MediaType.APPLICATION_JSON)
		    .content(new ObjectMapper().writeValueAsString(updateStreaming)))
		    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		    .andExpect(status().isOk());
	   moviesProxy.deleteMovie(createMovie.getId());
	}

	@Test
	@Order(6)
	@DisplayName("6 - Must update a streaming with a serie successfully")
	void updateWithSerieSuccessfully() throws Exception {
		Streaming streaming = CreateStreaming.create();
		streamingRepository.save(streaming);
		SeriesDto serie = CreateStreaming.serie();
		Series createSerie = seriesProxy.createSerie(serie);
		Streaming updateStreaming = CreateStreaming.updateSerie(createSerie.getId());
	    mockMvc.perform(patch("/streaming-service/addSerie?id="
            + streaming.getId()
            + "&idSerie="
            + createSerie.getId())
	    	.contentType(MediaType.APPLICATION_JSON)
	    	.content(new ObjectMapper().writeValueAsString(updateStreaming)))
	        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());
       seriesProxy.deleteSerie(createSerie.getId());
	}
}
