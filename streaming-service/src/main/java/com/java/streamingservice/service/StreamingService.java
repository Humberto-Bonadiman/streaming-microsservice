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
import com.java.streamingservice.repository.StreamingRepository;
import com.java.streamingservice.response.Movies;

@Service
@Component
public class StreamingService {

	@Autowired
	StreamingRepository streamingRepository;

    @Autowired
    private MoviesProxy moviesProxy;

	public Streaming create(StreamingDto streamingDto) {
		List<HashMap<String, String>> emptyList = new ArrayList<HashMap<String, String>>();
		Streaming streaming = new Streaming(
		    streamingDto.getCategory(),
		    streamingDto.getTypes(),
		    emptyList
		);
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
		return streamingMovie;
	}

	public void delete(String id) {
		streamingRepository.deleteById(id);
	}
}
