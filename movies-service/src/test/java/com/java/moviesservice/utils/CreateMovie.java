package com.java.moviesservice.utils;

import com.java.moviesservice.model.Movies;
import java.util.ArrayList;
import java.util.List;

public class CreateMovie {

	public static Movies create() {
		List<String> categories = new ArrayList<String>();
		categories.add("Romance");
		categories.add("Comédia dramática");
		Movies movie = new Movies(
		    "Tempos Modernos",
		    "First synopsis",
		    "1h27m",
		    1936,
		    "image_movie",
		    categories
		);
		return movie;
	}

	public static Movies createSecond() {
		List<String> categories = new ArrayList<String>();
		categories.add("comédia");
		Movies movie = new Movies(
		    "O Grande Ditador",
		    "Second synopsis",
		    "2h05m",
		    1940,
		    "image_movie",
		    categories
		);
		return movie;
	}

	public static Movies updateFirst() {
		List<String> categories = new ArrayList<String>();
		categories.add("Romance");
		categories.add("Comédia");
		Movies movieUpdate = create();
		movieUpdate.setTitle("Tempos Modernos");
		movieUpdate.setSynopsis("First correct synopsis");
		movieUpdate.setDuration("1h27m");
		movieUpdate.setReleaseYear(1936);
		movieUpdate.setImage("changed_image_movie");
		movieUpdate.setCategories(categories);
		return movieUpdate;
	}
}
