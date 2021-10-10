package com.devsuperior.bds02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.EventService;

@RestController
@RequestMapping( value ="/events")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EventDTO> updateEvent( @PathVariable("id") Long id, @RequestBody EventDTO eventDTO ) {
		
		eventDTO = eventService.update(id, eventDTO );
		return ResponseEntity.ok().body(eventDTO) ;
	}
}