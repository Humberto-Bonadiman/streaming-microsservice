package com.java.streamingservice.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.java.streamingservice.model.Streaming;

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
		List<String> types = new ArrayList<String>(
				Arrays.asList("movies", "series"));
			HashMap<String, Object> audiovisual =
				new HashMap<String, Object>();
		audiovisual.put("id", 1000000);
		audiovisual.put("title", "Tempos Modernos");
		audiovisual.put("image", "image_movie");
		audiovisual.put("type", "movie");
		List<HashMap<String, Object>> audiovisualProduct =
		    new ArrayList<HashMap<String, Object>>();
		audiovisualProduct.add(audiovisual);
		Streaming streaming = new Streaming(
			id,
			"first_category",
			types,
			audiovisualProduct
		);

		return streaming;
	}

	public static Streaming updateSerie(Integer id) {
		List<String> types = new ArrayList<String>(
			Arrays.asList("movies", "series"));
		HashMap<String, Object> audiovisual =
			new HashMap<String, Object>();
		audiovisual.put("id", 1000000);
		audiovisual.put("title", "ALF, o Eteimoso");
		audiovisual.put("image", "first_image");
		audiovisual.put("type", "serie");
		List<HashMap<String, Object>> audiovisualProduct =
		    new ArrayList<HashMap<String, Object>>();
		audiovisualProduct.add(audiovisual);
		Streaming streaming = new Streaming(
			id,
			"first_category",
			types,
			audiovisualProduct
		);

		return streaming;
	}

}
