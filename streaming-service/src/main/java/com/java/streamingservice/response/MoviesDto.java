package com.java.streamingservice.response;

import java.util.List;

public class MoviesDto {

	private String title;

	private String synopsis;

	private String duration;

	private Integer releaseYear;

	private String image;

	private List<String> categories;

	

	public MoviesDto(
		String title,
		String synopsis,
		String duration,
		Integer releaseYear,
		String image,
		List<String> categories
	) {
		this.title = title;
		this.synopsis = synopsis;
		this.duration = duration;
		this.releaseYear = releaseYear;
		this.image = image;
		this.categories = categories;
	}

	public String getTitle() {
		return title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public String getDuration() {
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
