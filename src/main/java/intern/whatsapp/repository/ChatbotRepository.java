package intern.whatsapp.repository;

import org.springframework.data.repository.CrudRepository;

import intern.whatsapp.entity.UserMessage;

public interface ChatbotRepository extends CrudRepository<UserMessage, Integer> {

}
