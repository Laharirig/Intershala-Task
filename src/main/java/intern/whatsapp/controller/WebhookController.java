package intern.whatsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import intern.whatsapp.service.ChatbotService;

@RestController
@RequestMapping("/webhook")
public class WebhookController {
	@Autowired
    private ChatbotService chatbotService;

    @PostMapping
    public ResponseEntity<String> receiveMessage(@RequestBody String payload) throws JsonMappingException, JsonProcessingException {
        chatbotService.processMessage(payload);
        return ResponseEntity.ok("Message received");
    }
}
