package com.java.streamingservice.response;

import java.util.List;
import java.util.Objects;

public class Movies {

	private Integer id;

	private String title;

	private String synopsis;

	private String duration;

	private Integer releaseYear;

	private String image;

	private List<String> categories;

	public Movies() {}

	public Movies(
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

	public Movies(
	    Integer id,
	    String title,
	    String synopsis,
	    String duration,
	    Integer releaseYear,
	    String image,
	    List<String> categories
    ) {
		this.id = id;
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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
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
		return Objects.hash(categories, duration, id, image, releaseYear, synopsis, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		return Objects.equals(categories, other.categories) && Objects.equals(duration, other.duration)
				&& Objects.equals(id, other.id) && Objects.equals(image, other.image)
				&& Objects.equals(releaseYear, other.releaseYear) && Objects.equals(synopsis, other.synopsis)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", synopsis=" + synopsis + ", duration=" + duration
				+ ", releaseYear=" + releaseYear + ", image=" + image + ", categories=" + categories + "]";
	}
}
