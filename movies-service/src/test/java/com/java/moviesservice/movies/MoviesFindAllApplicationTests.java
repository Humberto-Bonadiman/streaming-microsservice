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
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MoviesFindAllApplicationTests {

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
	@Order(2)
	@DisplayName("2 - Must show all movies successfully")
	public void showAllMoviesSuccessfully() throws Exception {
		Movies firstMovie = CreateMovie.create();
		moviesRepository.save(firstMovie);
		Movies secondMovie = CreateMovie.createSecond();
		moviesRepository.save(secondMovie);
		mockMvc.perform(get("/movies-service"))
		    .andExpect(status().isOk())
		    .andExpect(jsonPath("$[0].title").value(firstMovie.getTitle()))
		    .andExpect(jsonPath("$[0].synopsis").value(firstMovie.getSynopsis()))
		    .andExpect(jsonPath("$[0].duration").value(firstMovie.getDuration()))
		    .andExpect(jsonPath("$[0].releaseYear").value(firstMovie.getReleaseYear()))
		    .andExpect(jsonPath("$[0].image").value(firstMovie.getImage()))
		    .andExpect(jsonPath("$[0].categories[0]").value(firstMovie.getCategories().get(0)))
		    .andExpect(jsonPath("$[1].title").value(secondMovie.getTitle()))
		    .andExpect(jsonPath("$[1].synopsis").value(secondMovie.getSynopsis()))
		    .andExpect(jsonPath("$[1].duration").value(secondMovie.getDuration()))
		    .andExpect(jsonPath("$[1].releaseYear").value(secondMovie.getReleaseYear()))
		    .andExpect(jsonPath("$[1].image").value(secondMovie.getImage()))
		    .andExpect(jsonPath("$[1].categories[0]").value(secondMovie.getCategories().get(0)));
	}
}
