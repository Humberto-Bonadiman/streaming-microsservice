package com.java.streamingservice.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("streaming")
public class Streaming implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String category;

	private List<String> types;

	private List<HashMap<String, String>> audiovisualProduct;

	public Streaming() {}

	public Streaming(
	    String category,
	    List<String> types,
	    List<HashMap<String, String>> audiovisualProduct
	) {
		this.category = category;
		this.types = types;
		this.audiovisualProduct = audiovisualProduct;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<HashMap<String, String>> getAudiovisualProduct() {
		return audiovisualProduct;
	}

	public void setAudiovisualProduct(List<HashMap<String, String>> audiovisualProduct) {
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
