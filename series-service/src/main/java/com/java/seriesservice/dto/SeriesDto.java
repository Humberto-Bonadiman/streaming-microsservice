package com.java.seriesservice.dto;

import java.util.List;

public class SeriesDto {

	private String title;

	private String synopsis;

	private Integer seasons;

	private Integer releaseYear;

	private List<Integer> episodesPerSeason;

	private String image;

	private List<String> categories;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getSeasons() {
		return seasons;
	}

	public void setSeasons(Integer seasons) {
		this.seasons = seasons;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public List<Integer> getEpisodesPerSeason() {
		return episodesPerSeason;
	}

	public void setEpisodesPerSeason(List<Integer> episodesPerSeason) {
		this.episodesPerSeason = episodesPerSeason;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}
