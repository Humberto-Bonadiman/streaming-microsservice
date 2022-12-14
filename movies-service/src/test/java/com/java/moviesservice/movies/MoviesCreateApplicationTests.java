package com.java.moviesservice.movies;

import com.java.moviesservice.model.Movies;
import com.java.moviesservice.repository.MoviesRepository;
import com.java.moviesservice.utils.CreateMovie;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MoviesCreateApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MoviesRepository moviesRepository;

	@BeforeEach
	void setUp() throws Exception {
		moviesRepository.deleteAll();
	}

	@AfterEach
	void cleanUp() {
        moviesRepository.deleteAll();
    }

	@Test
	@Order(1)
	@DisplayName("1 - Must register a movie successfully")
	public void registerMovieSuccessfully() throws Exception {
		Movies movie = CreateMovie.create();
		moviesRepository.save(movie);
	    mockMvc.perform(post("/movies-service")
	        .contentType(MediaType.APPLICATION_JSON)
	        .content(new ObjectMapper().writeValueAsString(movie)))
	        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isCreated());
	}
}
