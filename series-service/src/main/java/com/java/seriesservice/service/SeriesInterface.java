package com.java.seriesservice.service;

import com.java.seriesservice.dto.SeriesDto;
import com.java.seriesservice.model.Series;
import java.util.List;

public interface SeriesInterface {

	public Series create(SeriesDto seriesDto);

	public List<Series> listAll();

	public Series findById(Integer id);

	public Series update(Integer id, SeriesDto seriesDto);

	public void delete(Integer id);
}
