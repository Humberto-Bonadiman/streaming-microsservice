package com.java.streamingservice.service;

import com.java.streamingservice.dto.StreamingDto;
import com.java.streamingservice.model.Streaming;
import java.util.List;

public interface StreamingInterface {

	public Streaming create(StreamingDto seriesDto);

	public List<Streaming> listAll();

	public Streaming findById(Integer id);

	public Streaming updateWithMovies(Integer idStreaming, Integer idMovie);

	public Streaming updateWithSeries(Integer idStreaming, Integer idSerie);

	public void delete(Integer id);
}
