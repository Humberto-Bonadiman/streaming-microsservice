package com.java.streamingservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.streamingservice.dto.StreamingDto;
import com.java.streamingservice.model.Streaming;
import com.java.streamingservice.proxy.MoviesProxy;
import com.java.streamingservice.proxy.SeriesProxy;
import com.java.streamingservice.repository.StreamingRepository;
import com.java.streamingservice.response.Movies;
import com.java.streamingservice.response.Series;

@Service
public class StreamingService implements StreamingInterface {

	@Autowired
	StreamingRepository streamingRepository;

    @Autowired
    private MoviesProxy moviesProxy;

    @Autowired
    private SeriesProxy seriesProxy;

	public Streaming create(StreamingDto streamingDto) {
		List<HashMap<String, Object>> emptyList = new ArrayList<HashMap<String, Object>>();
		Streaming streaming = new Streaming(
		    streamingDto.getCategory(),
		    streamingDto.getTypes(),
		    emptyList
		);
		streamingRepository.save(streaming);
		return streaming;
	}

	public List<Streaming> listAll() {
		return streamingRepository.findAll();
	}

	public Streaming findById(Integer id) {
		return streamingRepository.findById(id).get();
	}

	public Streaming updateWithMovies(Integer idStreaming, Integer idMovie) {
		Streaming streamingMovie = streamingRepository.findById(idStreaming).get();
		Movies foundMovie = moviesProxy.getMovie(idMovie);
		HashMap<String, Object> movieInformation = new HashMap<String, Object>();
		movieInformation.put("id", foundMovie.getId());
		movieInformation.put("title", foundMovie.getTitle());
		movieInformation.put("image", foundMovie.getImage());
		List<HashMap<String, Object>> allAudioVisualProducts = streamingMovie.getAudiovisualProduct();
		allAudioVisualProducts.add(movieInformation);
		streamingMovie.setAudiovisualProduct(allAudioVisualProducts);
		streamingRepository.save(streamingMovie);
		return streamingMovie;
	}

	public Streaming updateWithSeries(Integer idStreaming, Integer idSerie) {
		Streaming streamingSerie = streamingRepository.findById(idStreaming).get();
		Series foundSerie = seriesProxy.getSerie(idSerie);
		HashMap<String, Object> serieInformation = new HashMap<String, Object>();
		serieInformation.put("id", foundSerie.getId());
		serieInformation.put("title", foundSerie.getTitle());
		serieInformation.put("image", foundSerie.getImage());
		List<HashMap<String, Object>> allAudioVisualProducts = streamingSerie.getAudiovisualProduct();
		allAudioVisualProducts.add(serieInformation);
		streamingSerie.setAudiovisualProduct(allAudioVisualProducts);
		streamingRepository.save(streamingSerie);
		return streamingSerie;
	}

	public void delete(Integer id) {
		streamingRepository.deleteById(id);
	}

}
