package com.java.seriesservice.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name = "series")
public class Series implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String title;

	@Column(name = "synopsis", nullable = false, columnDefinition = "LONGTEXT", length = 1000)
	@Size(min = 0, max = 1000)
	private String synopsis;

	@Column(nullable = false)
	private Integer seasons;

	@Column(nullable = false)
	private Integer releaseYear;

	@Column(name = "episodesPerSeason")
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> episodesPerSeason;

	@Column(name = "image")
	private String image;

	@Column(name = "categories")
	@ElementCollection(targetClass=String.class)
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
