package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jerome.roethlisberge on 30.03.14.
 */
@Service
public class VenueService {
	@Autowired
	private VenueRepository venueRepository;


	public void beforeSave(Venue venue){
	System.out.println("VenueService before Save has been triggered");
		venueRepository.save(venue);

	}

	public void beforeDelete(Long venueId){
		System.out.println("VenueService before delete has been triggered");
		venueRepository.delete(venueRepository.findOne(venueId));
	}
}
