package com.java.streamingservice.streaming;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.java.streamingservice.model.Streaming;
import com.java.streamingservice.proxy.MoviesProxy;
import com.java.streamingservice.proxy.SeriesProxy;
import com.java.streamingservice.repository.StreamingRepository;
import com.java.streamingservice.response.Movies;
import com.java.streamingservice.response.Series;
import com.java.streamingservice.service.StreamingService;
import com.java.streamingservice.utils.CreateStreaming;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("wiremock")
class StreamingUpdatesApplicationTest {

	private static WireMockServer wireMockServer;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StreamingRepository streamingRepository;
	
	@Autowired
	private StreamingService streamingService;

	@BeforeEach
	void setUp() throws Exception {


		streamingRepository.deleteAll();
	}

	@AfterEach
	void cleanUp() {
		streamingRepository.deleteAll();
	}

    // mudar withBody no teste 5 e no 6.

	@Test
	@Order(5)
	@DisplayName("5 - Must update a streaming with a movie successfully")
	public void testUpdateWithMovie() throws Exception {
	    // Cria um mockup do serviço MoviesProxy
	    MoviesProxy moviesProxy = mock(MoviesProxy.class);

	    // Configura o comportamento do mockup para retornar um objeto Movies quando o método getMovie for chamado
	    when(moviesProxy.getMovie(anyInt())).thenReturn(new Movies());

	    // Injeta o mockup como dependência do serviço StreamingService
	    ReflectionTestUtils.setField(streamingService, "moviesProxy", moviesProxy);

	    // Cria uma entidade de teste para ser utilizada pelo método de teste
	    Streaming newStreaming = CreateStreaming.create();
	    streamingRepository.save(newStreaming);
	    Streaming streaming = CreateStreaming.updateMovie(newStreaming.getId());
	    streamingRepository.save(streaming);

	    // Executa a requisição HTTP patch para o endpoint "/streaming-service/addMovie"
	    // com os parâmetros id e idMovie
	    mockMvc.perform(patch("/streaming-service/addMovie")
	        .param("id", Integer.toString(streaming.getId()))
	        .param("idMovie", "1000000"))
	        // Verifica se a resposta foi um código HTTP 200 (OK)
	        .andExpect(status().isOk());
	}


    @Test
	@Order(6)
	@DisplayName("6 - Must update a streaming with a serie successfully")
	void updateWithSerieSuccessfully() throws Exception {
	    SeriesProxy seriesProxy = mock(SeriesProxy.class);
	    when(seriesProxy.getSerie(anyInt())).thenReturn(new Series());
	    ReflectionTestUtils.setField(streamingService, "seriesProxy", seriesProxy);
	    Streaming newStreaming = CreateStreaming.create();
	    streamingRepository.save(newStreaming);
	    Streaming streaming = CreateStreaming.updateSerie(newStreaming.getId());
	    streamingRepository.save(streaming);
	    mockMvc.perform(patch("/streaming-service/addSerie")
	        .param("id", Integer.toString(streaming.getId()))
	        .param("idSerie", "1000000"))
	        .andExpect(status().isOk());
	}

}
