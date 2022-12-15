package com.java.streamingservice.response;

import java.util.List;
import java.util.Objects;

public class Series {

	private Integer id;

	private String title;

	private String synopsis;

	private Integer seasons;

	private Integer releaseYear;

	private List<Integer> episodesPerSeason;

	private String image;

	private List<String> categories;

	public Series() {}

	public Series(
	    String title,
	    String synopsis,
	    Integer seasons,
	    Integer releaseYear,
	    List<Integer> episodesPerSeason,
	    String image,
	    List<String> categories
	) {
		this.title = title;
		this.synopsis = synopsis;
		this.seasons = seasons;
		this.releaseYear = releaseYear;
		this.episodesPerSeason = episodesPerSeason;
		this.image = image;
		this.categories = categories;
	}



	public Series(
	    Integer id,
	    String title,
	    String synopsis,
	    Integer seasons,
	    Integer releaseYear,
	    List<Integer> episodesPerSeason,
	    String image,
	    List<String> categories
    ) {
		this.id = id;
		this.title = title;
		this.synopsis = synopsis;
		this.seasons = seasons;
		this.releaseYear = releaseYear;
		this.episodesPerSeason = episodesPerSeason;
		this.image = image;
		this.categories = categories;
	}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categories, episodesPerSeason, id, image, releaseYear, seasons, synopsis, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Series other = (Series) obj;
		return Objects.equals(categories, other.categories)
				&& Objects.equals(episodesPerSeason, other.episodesPerSeason) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image) && Objects.equals(releaseYear, other.releaseYear)
				&& Objects.equals(seasons, other.seasons) && Objects.equals(synopsis, other.synopsis)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Series [id=" + id + ", title=" + title + ", synopsis=" + synopsis + ", seasons=" + seasons
				+ ", releaseYear=" + releaseYear + ", episodesPerSeason=" + episodesPerSeason + ", image=" + image
				+ ", categories=" + categories + "]";
	}
}
