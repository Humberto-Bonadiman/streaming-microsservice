package com.java.moviesservice.dto;

import java.time.LocalDate;
import java.util.List;

public class MoviesDto {

	private String title;

	private String synopsis;

	private Integer duration;

	private LocalDate releaseDate;

	private String image;

	private List<String> categories;

	public String getTitle() {
		return title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public Integer getDuration() {
		return duration;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public String getImage() {
		return image;
	}

	public List<String> getCategories() {
		return categories;
	}
}
