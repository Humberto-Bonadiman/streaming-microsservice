package com.java.moviesservice.movies;

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

import com.java.moviesservice.model.Movies;
import com.java.moviesservice.repository.MoviesRepository;
import com.java.moviesservice.utils.CreateMovie;

@SpringBootTest
@AutoConfigureMockMvc
class MoviesUpdateApplicationTests {

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
	@Order(4)
	@DisplayName("4 - Must update a movie successfully")
	public void updateMovieSuccessfully() throws Exception {
		Movies movie = CreateMovie.create();
		moviesRepository.save(movie);
		Movies updateMovie = CreateMovie.updateFirst();
		moviesRepository.save(updateMovie);
	    mockMvc.perform(patch("/movies-service/" + movie.getId())
	        .contentType(MediaType.APPLICATION_JSON)
	        .content(new ObjectMapper().writeValueAsString(updateMovie)))
	        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());
	}
}
