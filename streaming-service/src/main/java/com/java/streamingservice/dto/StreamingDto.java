package com.java.streamingservice.dto;

import java.util.HashMap;
import java.util.List;

public class StreamingDto {

	private String category;

	private List<String> types;

	private List<HashMap<String, String>> audiovisualProduct;

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
}
