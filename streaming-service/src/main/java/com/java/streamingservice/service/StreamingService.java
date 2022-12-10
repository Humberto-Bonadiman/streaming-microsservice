package com.java.streamingservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.streamingservice.dto.StreamingDto;
import com.java.streamingservice.model.Streaming;
import com.java.streamingservice.proxy.MoviesProxy;
import com.java.streamingservice.proxy.SeriesProxy;
import com.java.streamingservice.repository.StreamingRepository;
import com.java.streamingservice.response.Movies;
import com.java.streamingservice.response.Series;

@Service
@Component
public class StreamingService {

	@Autowired
	StreamingRepository streamingRepository;

    @Autowired
    private MoviesProxy moviesProxy;

    @Autowired
    private SeriesProxy seriesProxy;

	public Streaming create(StreamingDto streamingDto) {
		List<HashMap<String, String>> emptyList = new ArrayList<HashMap<String, String>>();
		Streaming streaming = new Streaming(
		    streamingDto.getCategory(),
		    streamingDto.getTypes(),
		    emptyList
		);
		streamingRepository.save(streaming);
		return streaming;
	}

	public List<Streaming> showAll() {
		return streamingRepository.findAll();
	}

	public Streaming findById(String id) {
		return streamingRepository.findById(id).get();
	}

	public Streaming updateWithMovies(String idStreaming, String idMovie) {
		Streaming streamingMovie = streamingRepository.findById(idStreaming).get();
		Movies foundMovie = moviesProxy.getMovie(idMovie);
		HashMap<String, String> movieInformation = new HashMap<String, String>();
		movieInformation.put("id", foundMovie.getId());
		movieInformation.put("title", foundMovie.getTitle());
		movieInformation.put("image", foundMovie.getImage());
		List<HashMap<String, String>> allAudioVisualProducts = streamingMovie.getAudiovisualProduct();
		allAudioVisualProducts.add(movieInformation);
		streamingMovie.setAudiovisualProduct(allAudioVisualProducts);
		streamingRepository.save(streamingMovie);
		return streamingMovie;
	}

	public Streaming updateWithSeries(String idStreaming, String idSerie) {
		Streaming streamingSerie = streamingRepository.findById(idStreaming).get();
		Series foundSerie = seriesProxy.getSerie(idSerie);
		HashMap<String, String> serieInformation = new HashMap<String, String>();
		serieInformation.put("id", foundSerie.getId());
		serieInformation.put("title", foundSerie.getTitle());
		serieInformation.put("image", foundSerie.getImage());
		List<HashMap<String, String>> allAudioVisualProducts = streamingSerie.getAudiovisualProduct();
		allAudioVisualProducts.add(serieInformation);
		streamingSerie.setAudiovisualProduct(allAudioVisualProducts);
		streamingRepository.save(streamingSerie);
		return streamingSerie;
	}

	public void delete(String id) {
		streamingRepository.deleteById(id);
	}
}
