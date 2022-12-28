package com.java.seriesservice.service;

import com.java.seriesservice.dto.SeriesDto;
import com.java.seriesservice.exception.message.SerieNotRegisteredException;
import com.java.seriesservice.model.Series;
import com.java.seriesservice.repository.SeriesRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
		return findSerieById(id);
	}

	@Override
	public Series update(Integer id, SeriesDto seriesDto) {
		Series serie = findSerieById(id);
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
		findSerieById(id);
		seriesRepository.deleteById(id);
	}
	
	private Series findSerieById(Integer id) {
		Optional<Series> validSerie = seriesRepository.findById(id);
		if (validSerie.isEmpty()) {
			throw new SerieNotRegisteredException();
		}
		return validSerie.get();
	}
}
