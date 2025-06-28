package intern.whatsapp.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import intern.whatsapp.entity.UserMessage;
import intern.whatsapp.repository.ChatbotRepository;

@Service
public class ChatbotService {

	@Autowired
	private ChatbotRepository messageRepo;

	public void processMessage(String payload) throws JsonMappingException, JsonProcessingException {
		// Extract sender and text from payload JSON
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(payload);
		String from = root.at("/entry/0/changes/0/value/messages/0/from").asText();
		String text = root.at("/entry/0/changes/0/value/messages/0/text/body").asText();


		UserMessage msg = new UserMessage(from, text, LocalDateTime.now());
		messageRepo.save(msg);

		System.out.println("Message saved to DB: " + text);
	}
}
