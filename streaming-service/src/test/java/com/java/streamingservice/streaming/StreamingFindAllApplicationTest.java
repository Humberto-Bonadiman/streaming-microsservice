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
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class StreamingFindAllApplicationTest {

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
	@Order(2)
	@DisplayName("2 - Must show all data of streaming successfully")
	public void showAllStreamingDataSuccessfully() throws Exception {
		Streaming firstStreaming = CreateStreaming.create();
		streamingRepository.save(firstStreaming);
		List<HashMap<String, Object>> audiovisualProduct =
			    new ArrayList<HashMap<String, Object>>();
		Streaming secondStreaming = CreateStreaming.createSecond();
		streamingRepository.save(secondStreaming);
		mockMvc.perform(get("/streaming-service"))
		    .andExpect(status().isOk())
		    .andExpect(jsonPath("$[0].category").value(firstStreaming.getCategory()))
		    .andExpect(jsonPath("$[0].types[0]").value(firstStreaming.getTypes().get(0)))
		    .andExpect(jsonPath("$[0].audiovisualProduct").value(audiovisualProduct))
		    .andExpect(jsonPath("$[1].category").value(secondStreaming.getCategory()))
		    .andExpect(jsonPath("$[1].types[0]").value(secondStreaming.getTypes().get(0)))
		    .andExpect(jsonPath("$[1].audiovisualProduct").value(audiovisualProduct));
	}
}
