package ch.steampilot.spem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by jerome.roethlisberge on 30.03.14.
 */
@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;


	public void beforeSave(Event event){
	System.out.println("EventService before Save has been triggered");
		eventRepository.save(event);

	}

	public void beforeDelete(Long eventId){
		System.out.println("EventService before delete has been triggered");
		eventRepository.delete(eventRepository.findOne(eventId));
	}
}
