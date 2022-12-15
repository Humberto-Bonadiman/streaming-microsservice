package com.java.streamingservice.streaming;

import com.java.streamingservice.model.Streaming;
import com.java.streamingservice.repository.StreamingRepository;
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
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StreamingFindByIdApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StreamingRepository streamingRepository;

	@BeforeEach
	void setUp() throws Exception {
		streamingRepository.deleteAll();
	}

	@AfterEach
	void tearDown() throws Exception {
		streamingRepository.deleteAll();
	}

	@Test
	@Order(3)
	@DisplayName("3 - Must find a data of streaming by id successfully")
	void findStreamingDataByIdSuccessfully() throws Exception {
		Streaming streaming = CreateStreaming.create();
		streamingRepository.save(streaming);
	    mockMvc.perform(get("/streaming-service/" + streaming.getId())
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(new ObjectMapper().writeValueAsString(streaming)))
		        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk());
	}

}
