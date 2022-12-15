package com.java.seriesservice.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.java.seriesservice.model.Series;

public class SeriesCreate {

	public static Series create() {
		List<Integer> episodes = new ArrayList<Integer>(Arrays.asList(26, 26, 26, 24));
		List<String> categories = new ArrayList<String>(
		    Arrays.asList("Comédia", "Ficção científica", "Fantasia")
	    );
		Series serie = new Series(
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

	public static Series createSecond() {
		List<Integer> episodes = new ArrayList<Integer>(Arrays.asList(5, 24, 22, 14));
		List<String> categories = new ArrayList<String>(
		    Arrays.asList("Comédia", "Família")
	    );
		Series serie = new Series(
            "Família Dinossauros",
            "second_synopsis",
            4,
            1991,
            episodes,
            "second_image",
            categories
		);
		return serie;
	}

	public static Series updateSerie() {
		List<Integer> episodes = new ArrayList<Integer>(Arrays.asList(26, 26, 26, 24));
		List<String> categories = new ArrayList<String>(
		    Arrays.asList("Comédia", "Fantasia")
	    );
		Series serie = create();
        serie.setTitle("ALF, o Eteimoso");
        serie.setSynopsis("first_synopsis");
        serie.setSeasons(4);
        serie.setReleaseYear(1986);
        serie.setEpisodesPerSeason(episodes);
        serie.setImage("first_image");
        serie.setCategories(categories);
		return serie;
	}
	
}
