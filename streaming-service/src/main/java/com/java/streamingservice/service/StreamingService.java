package com.java.streamingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.streamingservice.dto.StreamingDto;
import com.java.streamingservice.model.Streaming;
import com.java.streamingservice.repository.StreamingRepository;

@Service
@Component
public class StreamingService {

	@Autowired
	StreamingRepository streamingRepository;

	public Streaming create(StreamingDto streamingDto) {
		Streaming streaming = new Streaming(
		    streamingDto.getCategory(),
		    streamingDto.getAudiovisualProduct(),
		    streamingDto.getTypes()
		);
		return streaming;
	}

	public List<Streaming> showAll() {
		return streamingRepository.findAll();
	}

	public Streaming findById(String id) {
		return streamingRepository.findById(id).get();
	}

	public void delete(String id) {
		streamingRepository.deleteById(id);
	}
}
