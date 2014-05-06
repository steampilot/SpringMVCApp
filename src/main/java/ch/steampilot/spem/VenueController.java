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
class VenueController {
    @Autowired
    private VenueRepository venueRepository;
	@Autowired
	private VenueService venueService;

    @RequestMapping(value = "/venue/list", method = RequestMethod.GET)
    public String listVenues(ModelMap model) {
        model.addAttribute("venue", new Venue());
        model.addAttribute("venues", venueRepository.findAll());
        return "venues";
    }

    @RequestMapping(value = "/api/venues", method = RequestMethod.GET)
    public
    @ResponseBody
    String listVenuesJson(ModelMap model) throws JSONException {
        JSONArray venueArray = new JSONArray();
        for (Venue venue : venueRepository.findAll()) {
            JSONObject venueJSON = new JSONObject();
            venueJSON.put("id", venue.getId());
	        venueJSON.put("title", venue.getTitle());
	        venueJSON.put("description", venue.getDescription());
	        venueJSON.put("address1", venue.getAddress1());
	        venueJSON.put("address2", venue.getAddress2());
	        venueJSON.put("zipCode", venue.getZipCode());
	        venueJSON.put("city", venue.getCity());
	        venueJSON.put("country", venue.getCountry());
            venueArray.put(venueJSON);
        }
        return venueArray.toString();
    }

    @RequestMapping(value = "/venue/add", method = RequestMethod.POST)
    public String addVenue(@ModelAttribute("venue") Venue venue, BindingResult result) {
        venueService.beforeSave(venue);
	    //venueRepository.save(venue);
        return "redirect:/venue/list";
    }

    @RequestMapping("/venue/delete/{venueId}")
    public String deleteVenue(@PathVariable("venueId") Long venueId) {
        venueService.beforeDelete(venueId);
	    ///venueRepository.delete(venueRepository.findOne(venueId));
        return "redirect:/venue/list";
    }
}