package ch.steampilot.spem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jerome.roethlisberge on 30.03.14.
 */
@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;


	public void beforeSave(Person person){
	System.out.println("PersonService before Save has been triggered");
		personRepository.save(person);

	}

	public void beforeDelete(Long personId){
		System.out.println("PersonService before delete has been triggered");
		personRepository.delete(personRepository.findOne(personId));
	}
}
