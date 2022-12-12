package com.java.moviesservice.dto;

import java.time.LocalTime;
import java.util.List;

public class MoviesDto {

	private String title;

	private String synopsis;

	private LocalTime duration;

	private Integer releaseYear;

	private String image;

	private List<String> categories;

	public String getTitle() {
		return title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public String getImage() {
		return image;
	}

	public List<String> getCategories() {
		return categories;
	}
}
