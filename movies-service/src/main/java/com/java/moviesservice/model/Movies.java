package com.java.moviesservice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "movies")
public class Movies implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String synopsis;

	@Column(nullable = false)
	private Integer duration;

	@Column(name = "release_date")
	private LocalDate releaseDate;

	@Column(name = "image")
	private String image;

	@Column(name = "categories")
	@ElementCollection(targetClass=String.class)
	private List<String> categories;

	public Movies() {}

	public Movies(
	    String title,
	    String synopsis,
	    Integer duration,
	    LocalDate releaseDate,
	    String image,
	    List<String> categories
	) {
		super();
		this.title = title;
		this.synopsis = synopsis;
		this.duration = duration;
		this.releaseDate = releaseDate;
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
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
		return Objects.hash(categories, duration, id, image, releaseDate, synopsis, title);
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
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(synopsis, other.synopsis)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", synopsis=" + synopsis + ", duration=" + duration
				+ ", releaseDate=" + releaseDate + ", image=" + image + ", categories=" + categories + "]";
	}
}
