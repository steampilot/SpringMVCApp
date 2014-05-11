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
class PersonController {
    @Autowired
    private PersonRepository personRepository;

	@Autowired
	private PersonService personService;

    @RequestMapping(value = "/person/list", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("person", new Person());
        model.addAttribute("persons", personRepository.findAll());
        return "persons";
    }

    @RequestMapping(value = "/api/person", method = RequestMethod.GET)
    public
    @ResponseBody
    String listPersonsJson(ModelMap model) throws JSONException {
        JSONArray personArray = new JSONArray();
        for (Person person : personRepository.findAll()) {
            JSONObject personJSON = new JSONObject();
            personJSON.put("id", person.getId());
            personJSON.put("firstName", person.getFirstName());
            personJSON.put("lastName", person.getLastName());
	        personJSON.put("birthDay", person.getBirthday());
	        personJSON.put("address1", person.getAddress1());
	        personJSON.put("address2", person.getAddress2());
	        personJSON.put("zipCode", person.getZipCode());
	        personJSON.put("city", person.getCity());
	        personJSON.put("country", person.getCountry());
            personJSON.put("email", person.getEmail());
            personArray.put(personJSON);
        }
        return personArray.toString();
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person, BindingResult result) {
        personService.beforeSave(person);
	    //personRepository.save(person);
        return "redirect:/person/list";
    }

    @RequestMapping("/person/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Long personId) {
        personService.beforeDelete(personId);
	    //personRepository.delete(personRepository.findOne(personId));
        return "redirect:/person/list";
    }
}