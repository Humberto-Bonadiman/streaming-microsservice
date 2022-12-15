package com.java.streamingservice.streaming;

import com.java.streamingservice.model.Streaming;
import com.java.streamingservice.repository.StreamingRepository;
import com.java.streamingservice.utils.CreateStreaming;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class StreamingDeleteApplicationTest {

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
	@Order(4)
	@DisplayName("4 - Must delete a data of streaming successfully")
	void test() throws Exception {
		Streaming streaming = CreateStreaming.create();
		streamingRepository.save(streaming);
	    mockMvc.perform(delete("/streaming-service/" + streaming.getId()))
            .andExpect(status().isNoContent());
	}

}
