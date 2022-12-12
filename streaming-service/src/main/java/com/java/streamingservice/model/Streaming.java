package com.java.streamingservice.model;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "streaming")
public class Streaming {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "category", nullable = false, length = 180)
	private String category;

	@Column(name = "types", nullable = false)
	private List<String> types;

	@Column(name = "audio_visual_product")
	private List<HashMap<String, Object>> audiovisualProduct;

	public Streaming() {}

	public Streaming(
	    String category,
	    List<String> types,
	    List<HashMap<String, Object>> audiovisualProduct
	) {
		this.category = category;
		this.types = types;
		this.audiovisualProduct = audiovisualProduct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<HashMap<String, Object>> getAudiovisualProduct() {
		return audiovisualProduct;
	}

	public void setAudiovisualProduct(List<HashMap<String, Object>> audiovisualProduct) {
		this.audiovisualProduct = audiovisualProduct;
	}

	@Override
	public int hashCode() {
		return Objects.hash(audiovisualProduct, category, id, types);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Streaming other = (Streaming) obj;
		return Objects.equals(audiovisualProduct, other.audiovisualProduct) && Objects.equals(category, other.category)
				&& Objects.equals(id, other.id) && Objects.equals(types, other.types);
	}

	@Override
	public String toString() {
		return "Streaming [id=" + id + ",\ncategory=" + category + ",\ntypes=" + types + ",\naudiovisualProduct="
				+ audiovisualProduct + "]";
	}
}
