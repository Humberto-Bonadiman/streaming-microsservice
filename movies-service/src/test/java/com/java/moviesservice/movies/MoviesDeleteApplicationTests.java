package com.java.moviesservice.movies;

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

import com.java.moviesservice.model.Movies;
import com.java.moviesservice.repository.MoviesRepository;
import com.java.moviesservice.utils.CreateMovie;

@SpringBootTest
@AutoConfigureMockMvc
class MoviesDeleteApplicationTests {

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
	@Order(5)
	@DisplayName("5 - Must delete a movie successfully")
	public void deleteMovieSuccessfully() throws Exception {
		Movies movie = CreateMovie.create();
		moviesRepository.save(movie);
	    mockMvc.perform(delete("/movies-service/" + movie.getId()))
	        .andExpect(status().isNoContent());
	}

}
