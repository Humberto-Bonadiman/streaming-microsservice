package com.java.seriesservice.service;

import com.java.seriesservice.dto.SeriesDto;
import com.java.seriesservice.model.Series;
import java.util.List;

public interface SeriesInterface {

	public Series create(SeriesDto seriesDto);

	public List<Series> listAll();

	public Series findById(String id);

	public Series update(String id, SeriesDto seriesDto);

	public void delete(String id);
}
