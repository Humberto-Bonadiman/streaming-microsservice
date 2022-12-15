package com.java.streamingservice.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.java.streamingservice.model.Streaming;
import com.java.streamingservice.response.Movies;
import com.java.streamingservice.response.MoviesDto;
import com.java.streamingservice.response.Series;
import com.java.streamingservice.response.SeriesDto;

public class CreateStreaming {

	public static Streaming create() {
		List<String> types = new ArrayList<String>(
			Arrays.asList("movies", "series"));
		List<HashMap<String, Object>> audiovisualProduct =
		    new ArrayList<HashMap<String, Object>>();
		Streaming streaming = new Streaming(
		    "first_category",
		    types,
		    audiovisualProduct
		);
		return streaming;
	}

	public static Streaming createSecond() {
		List<String> types = new ArrayList<String>(
				Arrays.asList("movies", "series"));
		List<HashMap<String, Object>> audiovisualProduct =
			    new ArrayList<HashMap<String, Object>>();
		Streaming streaming = new Streaming(
		    "second_category",
		    types,
			audiovisualProduct
		);
		return streaming;
	}

	public static Streaming updateMovie(Integer id) {
		HashMap<String, Object> audiovisualProduct =
		    new HashMap<String, Object>();
		Streaming streaming = create();
		audiovisualProduct.put("id", id);
		audiovisualProduct.put("title", "Tempos Modernos");
		audiovisualProduct.put("image", "image_movie");
		audiovisualProduct.put("type", "movie");
		return streaming;
	}

	public static Streaming updateSerie(Integer id) {
		HashMap<String, Object> audiovisualProduct =
			new HashMap<String, Object>();
		Streaming streaming = create();
		audiovisualProduct.put("id", id);
		audiovisualProduct.put("title", "ALF, o Eteimoso");
		audiovisualProduct.put("image", "first_image");
		audiovisualProduct.put("type", "serie");
		return streaming;
	}

	public static MoviesDto movie() {
		List<String> categories = new ArrayList<String>();
		categories.add("Romance");
		categories.add("Comédia dramática");
		MoviesDto newMovie = new MoviesDto(
		    "Tempos Modernos",
		    "First synopsis",
		    "1h27m",
		    1936,
		    "image_movie",
		    categories
		);
		return newMovie;
	}

	public static SeriesDto serie() {
		List<Integer> episodes = new ArrayList<Integer>(Arrays.asList(26, 26, 26, 24));
		List<String> categories = new ArrayList<String>(
		    Arrays.asList("Comédia", "Ficção científica", "Fantasia")
	    );
		SeriesDto serie = new SeriesDto(
            "ALF, o Eteimoso",
            "first_synopsis",
            4,
            1986,
            episodes,
            "first_image",
            categories
		);
		return serie;
	}
}
