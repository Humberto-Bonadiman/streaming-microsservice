package com.java.moviesservice.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Size;

@Entity(name = "movies")
public class Movies implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String title;

	@Lob
	@Column(name = "synopsis", nullable = false, columnDefinition = "LONGTEXT", length = 1000)
	@Size(min = 0, max = 1000)
	private String synopsis;

	@Column(nullable = false)
	private String duration;

	@Column(name = "release_year")
	private Integer releaseYear;

	@Column(name = "image")
	private String image;

	@Column(name = "categories")
	@ElementCollection(targetClass=String.class)
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
		super();
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
