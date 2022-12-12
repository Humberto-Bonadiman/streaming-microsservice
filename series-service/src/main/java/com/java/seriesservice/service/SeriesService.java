package com.java.seriesservice.service;

import com.java.seriesservice.dto.SeriesDto;
import com.java.seriesservice.model.Series;
import com.java.seriesservice.repository.SeriesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class SeriesService implements SeriesInterface {

	@Autowired
	SeriesRepository seriesRepository;

	@Override
	public Series create(SeriesDto seriesDto) {
		Series serie = new Series(
		    seriesDto.getTitle(),
		    seriesDto.getSynopsis(),
		    seriesDto.getReleaseYear(),
		    seriesDto.getSeasons(),
		    seriesDto.getEpisodesPerSeason(),
		    seriesDto.getImage(),
		    seriesDto.getCategories()
		);
		seriesRepository.save(serie);
		return serie;
	}

	@Override
	public List<Series> listAll() {
		return seriesRepository.findAll();
	}

	@Override
	public Series findById(Integer id) {
		return seriesRepository.findById(id).get();
	}

	@Override
	public Series update(Integer id, SeriesDto seriesDto) {
		Series serie = seriesRepository.findById(id).get();
	    serie.setTitle(seriesDto.getTitle());
	    serie.setSynopsis(seriesDto.getSynopsis());
	    serie.setReleaseYear(seriesDto.getReleaseYear());
	    serie.setSeasons(seriesDto.getSeasons());
	    serie.setEpisodesPerSeason(seriesDto.getEpisodesPerSeason());
	    serie.setImage(seriesDto.getImage());
	    serie.setCategories(seriesDto.getCategories());
	    seriesRepository.save(serie);
		return serie;
	}

	@Override
	public void delete(Integer id) {
		seriesRepository.deleteById(id);
	}
}
