package ch.steampilot.spem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
class EventController {
    @Autowired
    private EventRepository eventRepository;

	@Autowired
	private EventService eventService;

    @RequestMapping(value = "/event/list", method = RequestMethod.GET)
    public String listEvents(ModelMap model) {
        model.addAttribute("event", new Event());
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }

    @RequestMapping(value = "/api/event", method = RequestMethod.GET)
    public
    @ResponseBody
    String listEventsJson(ModelMap model) throws JSONException {
        JSONArray eventArray = new JSONArray();
        for (Event event : eventRepository.findAll()) {
            JSONObject eventJSON = new JSONObject();
            eventJSON.put("id", event.getId());
	        eventJSON.put("title", event.getTitle());
	        eventJSON.put("description", event.getDescription());
	        eventJSON.put("beginDate", event.getBeginDate());
	        eventJSON.put("endDate", event.getEndDate());
            eventArray.put(eventJSON);
        }
        return eventArray.toString();
    }

    @RequestMapping(value = "/event/add", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute("event") Event event, BindingResult result) {
		eventService.beforeSave(event);
        return "redirect:/event/list";
    }

    @RequestMapping("/event/delete/{eventId}")
    public String deleteEvent(@PathVariable("eventId") Long eventId) {
		eventService.beforeDelete(eventId);
		//eventRepository.delete(eventRepository.findOne(eventId));
        return "redirect:/event/list";
    }
}